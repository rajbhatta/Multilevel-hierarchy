package com.hatchways.controllers;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.hatchways.models.OrderDependency;

/**
 * 
 */

/**
 * @author mypc
 *
 */
public class MainRunner {
	public static void main(String[] args) throws IOException {
		
		 String orderPath = new File("input/orders.txt").getAbsolutePath();
		 String dependenciesPath = new File("input/dependencies.txt").getAbsolutePath();
		 String outputPath = new File("output/output.txt").getAbsolutePath();
		 BufferedWriter out = new BufferedWriter(new FileWriter(outputPath));
		 
		 NexusOrderController order=new NexusOrderController(orderPath,dependenciesPath);
		 order.readOrerInfo();
		 order.readDependenyInfo();
		 order.createSingletonInfo();
		 order.verifyListDependencyBeforeOperation(out);
		 out.close();
		 

	}

}
