package com.hatchways.controllers;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.hatchways.models.Dependency;
import com.hatchways.models.Order;
import com.hatchways.models.OrderDependency;

/**
 * 
 */

/**
 * @author mypc
 *
 */
public class NexusOrderController 
{
	    private final String fileOrderPath;
	    private final String fileDependenciesPath;
	   
	    private ArrayList<Order> orders;
	    private ArrayList<Integer> ordersIDList;
	    
	    private ArrayList<Dependency> dependencies;
	    private ArrayList<OrderDependency> orderDependencies;
	    private ArrayList<Integer> oderIDinDependecy;
	    
	    
	public NexusOrderController(String orderPath, String dependenciesPath)
	{
		this.fileOrderPath = orderPath;
        this.fileDependenciesPath = dependenciesPath;
        orders= new ArrayList<>();
        ordersIDList=new ArrayList();
        dependencies=new ArrayList<>();
        orderDependencies=new ArrayList<>();
        oderIDinDependecy=new ArrayList<>();    
	}
	
	public void readOrerInfo()
	{
		
		try {    
        	int i=0;
        	
	    	File file = new File(this.fileOrderPath);
	        Scanner scnr = new Scanner(file);
	  
	    	while(scnr.hasNextLine())
	    	{
	    	   String line = scnr.nextLine();  
	    	   String[] temp = line.split(",");   
	    	   
	    	   if(i!=0)
	    	   {	    	  
	    		   orders.add(new Order(Integer.parseInt(temp[0]),temp[1]));
	    		   ordersIDList.add(Integer.parseInt(temp[0]));
	    	   }
	    	   
	    	   i++;
	    }
	    	
	    	
	    	 	   	
    } catch (IOException e) {
        e.printStackTrace();
    } 
	}
	
	
	public void readDependenyInfo()
	{
		
		try {    
        	int i=0;
        	
	    	File file = new File(this.fileDependenciesPath);
	        Scanner scnr = new Scanner(file);
	  
	    	while(scnr.hasNextLine())
	    	{
	    	   String line = scnr.nextLine();  
	    	   String[] temp = line.split(",");   
	    	   
	    	   if(i!=0)
	    	   {	    	  
	    		   dependencies.add(new Dependency(Integer.parseInt(temp[0]),Integer.parseInt(temp[1])));
	    	   }
	    	   
	    	   i++;
	    	}
	    	
	    	
	    	 	   	
    } catch (IOException e) {
        e.printStackTrace();
    } 
	}
	
	public void createSingletonInfo()
	{
		for(Dependency dpn: dependencies)
		{
			for(Order ord: orders)
			{
				if(ord.getId()==dpn.getDependency_id())
				{
					orderDependencies.add(new OrderDependency(dpn.getDependency_id(),ord.getName(),dpn.getId()));
					oderIDinDependecy.add(dpn.getDependency_id());
				}
				
			}
		}
		
		ordersIDList.removeAll(oderIDinDependecy);
		
		for(int i=0;i<ordersIDList.size();i++){
			orderDependencies.add(new OrderDependency(ordersIDList.get(i),"Order "+ordersIDList.get(i),0));
			
		}

	}
	
	public void verifyListDependencyBeforeOperation(BufferedWriter out) throws IOException
	{
		
		for(OrderDependency dpr: orderDependencies)
		{
			System.out.println("ID \t"+dpr.getId()+"\t Name \t"+dpr.getNamel()+"\t Parent ID"+dpr.getParent_id());
		}
		
		recall_orderd_menu(orderDependencies,0,out);
	}
	
	public void recall_orderd_menu(ArrayList<OrderDependency> orderDependencyList,int parentID,BufferedWriter out) throws IOException
	{
		
        
		    for(OrderDependency orderDependency: orderDependencyList)
		    {
		    	if(orderDependency.getParent_id()==parentID)
		        {
			    	if(parentID==0)
			    	{
			    		out.write("Id:"+orderDependency.getId()+"\t Name: "+orderDependency.getNamel());
			            out.write("\n");
			    		out.write("\t Dependency");
			    		 out.write("\n");
			            
			    		System.out.println("Id:"+orderDependency.getId()+"\t Name: "+orderDependency.getNamel());
			    		System.out.println("\t Dependency");
			    		
			    		
			    		
			    		recall_orderd_menu(orderDependencyList,orderDependency.getId(),out);
			    	}
			    	else
			    	{
			    		
			    		   out.write("\t \t Id:"+orderDependency.getId()+"\t Name: "+orderDependency.getNamel());
			    		   out.write("\n");
			    		  
			    		   System.out.println("\t \t Id:"+orderDependency.getId()+"\t Name: "+orderDependency.getNamel());
				          
			    		   recall_orderd_menu(orderDependencyList,orderDependency.getId(),out);
				          
			    	}
		        }
		    }
	}

}
