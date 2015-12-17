//Name: Carlos Avogadro
//UFL ID: c.avogadro
//Section:6909
//Project Number: 1
//Brief description of file documents: Program that determines the likeliness of a student to be a criminal based on factors like ufid, location, BPM,etc.


import java.util.Scanner;

public class SuspicionCalculator {
	public static void main(String [] args){
		//initializing all variables
		String statusBpm;
		String lastNumsUfid;
		String StatusList;
		String criminalPotential;
		int TimeDiference;
		
		System.out.println("Hello and welcome to the UF suspect suspicion calculator.");
		Scanner input= new Scanner(System.in);
		
		//Time of crime
		System.out.print("Please enter the time of the crime: ");
		String StringCrimeTime= input.next();
				
		//Input for X coordinate of crime
		System.out.print("Please enter the latitude of the crime: ");
		int crimeLocationX= input.nextInt();
		
		//input for Y coordinate of crime
		System.out.print("Please enter the longitude of the crime: ");
		int crimeLocationY= input.nextInt();
		
		//Student UFID
		System.out.print("Please enter the student’s UFID: ");
		String ufid= input.next();
		
		//Student timestamp
		System.out.print("Please enter their last timestamp: ");
		String stringStudentTimeStamp= input.next();
		
		//Student X location
		System.out.print("Please enter the latitude of the student: ");
		int studentLocationX= input.nextInt();
		
		//Student Y location
		System.out.print("Please enter the longitude of the student: ");
		int studentLocationY= input.nextInt();
		
		//Student heart rate
		System.out.print("Please enter their heart rate: ");
		int heartRate= input.nextInt();
				
		//First number of UFID
		String ufidString = ufid.substring(0, 1);
		
	
		
			
		//Finds distance between crime and student
		double distance= Math.sqrt(Math.pow((studentLocationX-crimeLocationX),2)+Math.pow((studentLocationY-crimeLocationY),2));
		String strDouble = String.format("%.1f", distance);
		
			
		//Determine if person is walking or sedentary
		if(heartRate>=100){
			statusBpm="moving";
			
		} 
		else{
			statusBpm="sedentary";
			
		}
			
		//Find if student is on safety list or unsafe list
		lastNumsUfid = ufid.substring(6,8);
		int lastTwoId = Integer.parseInt(lastNumsUfid);
			
		if(lastTwoId>=50){
			StatusList="unsafe list";
				
				
		}
		else{
			StatusList="safe list";
				
		}
		int crimeTime= Integer.parseInt(StringCrimeTime);
		int studentTimeStamp=Integer.parseInt(stringStudentTimeStamp);
		
		if(StringCrimeTime.substring(0, 2).equals("00")&& stringStudentTimeStamp.substring(0, 2).equals("23")){
			
			TimeDiference=Math.abs(((24*60+crimeTime%100)-(23*60+studentTimeStamp%100)));
			
		}
		else{
		
			int crimeMins= (crimeTime/100)*60+crimeTime%100;
			int studentTime = (studentTimeStamp/100)*60+studentTimeStamp%100;
			TimeDiference=Math.abs(crimeMins-studentTime);
			
		}	
		
		//Highly likely
			//safe list
		if((TimeDiference<=30)&&(StatusList.equals("safe list"))&&(distance < 1)&&(statusBpm.equals("moving"))){
			criminalPotential="Highly Likely";
			System.out.println("\nStudent "+ufid+" who is on the "+StatusList +", and was "+ strDouble+" block units away, " +
					"at location ("+studentLocationX+","+studentLocationY+") at "+stringStudentTimeStamp+ " and determined " +
					"to be " +statusBpm+ " is "+criminalPotential+" to be the Criminal.");
			}
			//unsafe list
		else if((TimeDiference<=60)&&(StatusList.equals("unsafe list"))&&(distance <=1 )){
			criminalPotential="Highly Likely";
			System.out.println("\nStudent "+ufid+" who is on the "+StatusList +", and was "+ strDouble+" block units away, " +
					"at location ("+studentLocationX+","+studentLocationY+") at "+stringStudentTimeStamp+ " and determined " +
					"to be " +statusBpm+ " is "+criminalPotential+" to be the Criminal.");
			
		}
		
		//Likely
			//safe list
		else if((TimeDiference<=60)&&(StatusList.equals("safe list"))&&(distance <=1 )&&(statusBpm.equals("moving"))){
			criminalPotential="Likely";
			System.out.println("\nStudent "+ufid+" who is on the "+StatusList +", and was "+ strDouble+" block units away, " +
					"at location ("+studentLocationX+","+studentLocationY+") at "+stringStudentTimeStamp+ " and determined " +
					"to be " +statusBpm+ " is "+criminalPotential+" to be the Criminal.");
			}
		
			//unsafe list
		else if((TimeDiference<=90)&&(StatusList.equals("unsafe list"))&&(distance <=2 )&&(statusBpm.equals("moving"))){
			criminalPotential="Likely";
			System.out.println("\nStudent "+ufid+" who is on the "+StatusList +", and was "+ strDouble+" block units away, " +
					"at location ("+studentLocationX+","+studentLocationY+") at "+stringStudentTimeStamp+ " and determined " +
					"to be " +statusBpm+ " is "+criminalPotential+" to be the Criminal.");
		}
			
		//Unsure
			//safe list
		else if((TimeDiference<=90)&&(StatusList.equals("safe list"))&&(distance >3 )&&(statusBpm.equals("moving"))){
			criminalPotential="Unsure";
			System.out.println("\nStudent "+ufid+" who is on the "+StatusList +", and was "+ strDouble+" block units away, " +
					"at location ("+studentLocationX+","+studentLocationY+") at "+stringStudentTimeStamp+ " and determined " +
					"to be " +statusBpm+ " is "+criminalPotential+" to be the Criminal.");
		
		}
			//unsafe list
		else if((TimeDiference<=120)&&(StatusList.equals("unsafe list"))&&(distance >2 )){
			criminalPotential="Unsure";
			System.out.println("\nStudent "+ufid+" who is on the "+StatusList +", and was "+ strDouble+" block units away, " +
					"at location ("+studentLocationX+","+studentLocationY+") at "+stringStudentTimeStamp+ " and determined " +
					"to be " +statusBpm+ " is "+criminalPotential+" to be the Criminal.");
		}
		
		//Unlikely
			//safe list
		else if((TimeDiference<=120)&&(StatusList.equals("safe list"))&&(distance >4 )&&(statusBpm.equals("sedentary"))){
			criminalPotential="Unlikely";
			System.out.println("\nStudent "+ufid+" who is on the "+StatusList +", and was "+ strDouble+" block units away, " +
					"at location ("+studentLocationX+","+studentLocationY+") at "+stringStudentTimeStamp+ " and determined " +
					"to be " +statusBpm+ " is "+criminalPotential+" to be the Criminal.");
		
		}
			//unsafe list
		else if((TimeDiference<=150)&&(StatusList.equals("unsafe list"))&&(distance >3 )&&(statusBpm.equals("sedentary"))){
			criminalPotential="Unlikely";
			System.out.println("\nStudent "+ufid+" who is on the "+StatusList +", and was "+ strDouble+" block units away, " +
					"at location ("+studentLocationX+","+studentLocationY+") at "+stringStudentTimeStamp+ " and determined " +
					"to be " +statusBpm+ " is "+criminalPotential+" to be the Criminal.");
		}
		
		//Highly Unlikely
		else{
			criminalPotential="Highly Unlikely";
			System.out.println("\nStudent "+ufid+" who is on the "+StatusList +", and was "+ strDouble+" block units away, " +
					"at location ("+studentLocationX+","+studentLocationY+") at "+stringStudentTimeStamp+ " and determined " +
					"to be " +statusBpm+ " is "+criminalPotential+" to be the Criminal.");
			
		}
		
		}
	}
	