package com.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.model.Student;

@Repository
public class StudentDaoIMPL implements StudentDao {

	@Autowired
	private SessionFactory factory;

	public void chek(MultipartFile file) {

		Map<String, String> data = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line;
			boolean isHeader = true;

			while ((line = br.readLine()) != null) {
				// Skip header line
				if (isHeader) {
					isHeader = false;
					continue;
				}

				// Split the line into columns
				String[] columns = line.split(",");

				// Ensure the CSV has the correct number of columns
				if (columns.length == 2) {
					String id = columns[0];
					String value = columns[1];
					data.put(id, value);
				} else {
					System.out.println("Invalid line: " + line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Print the map to verify the data
		for (Map.Entry<String, String> entry : data.entrySet()) {
//				System.out.println("ID: " + entry.getKey() + ", Value: " + entry.getValue());
//				
			int id = Integer.parseInt(entry.getKey());

			Session session = factory.openSession();
			Student stu = session.get(Student.class, id);
			if (entry.getValue() != stu.getResult()) {
				Transaction tx = session.beginTransaction();
				stu.setResult(entry.getValue());
				session.update(stu);
				tx.commit();
			} else {
				session.beginTransaction().commit();
			}

		}

		System.out.println("Update Done");
	}
}
