package com.api.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.api.entity.Student;



public class HelperToUpload {

	public static boolean checkFormat(MultipartFile file) {

		String contentType = file.getContentType();
		if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		} else {
			return false;
		}

	}

	public static List<Student> convertExceltoListOfStudent(InputStream ios) {

		List<Student> studentList = new ArrayList<>();

		try {
			XSSFWorkbook workbook = new XSSFWorkbook(ios);
			XSSFSheet sheet = workbook.getSheet("Sheet1");

			int rowNumber = 0;
			Iterator<Row> iterator = sheet.iterator();

			while (iterator.hasNext()) {
				Row row = iterator.next();

				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> iterator2 = row.iterator();

				int StdId = 0;

				Student std = new Student();
				while (iterator2.hasNext()) {
					Cell cell = iterator2.next();
					switch (StdId) {
					case 0:
						std.setID((int)cell.getNumericCellValue());
						break;
					case 1:
						std.setName(cell.getStringCellValue());
						break;
					case 2:
						std.setEmail(cell.getStringCellValue());
						break;
					case 3:
						std.setPhoneNo((int)cell.getNumericCellValue()) ;
						break;
					default:
						break;
					}
					StdId++;
				}
				studentList.add(std);
			}

		} catch (Exception exp) {
			exp.printStackTrace();
		}

		return studentList;

	}
}
