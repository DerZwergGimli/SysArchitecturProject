package testlidar;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class lidar {
	
	//static int baudRate = 9600;
	private static String scan = "/home/pi/xv11lidar-test/lidarscan.sh";
	private static String stop = "/home/pi/xv11lidar-test/lidarstop.sh";
	private static String startLidarRot = "/home/pi/xv11lidar-test/lidarinit.sh" ;

	public static void main(String[] args) throws Exception {
		
	    Process s = Runtime.getRuntime().exec(startLidarRot);
	    int w=0;
	    while(w<1)
	    {
	    Process p = Runtime.getRuntime().exec(scan);
	    //p.waitFor();
	    
	    String[] lines = new String[2];
	    BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    
	    String line;
	    int i =0;
	    
	    while((line = reader.readLine())!= null)
	    {
	    	lines[i] = line;
	    	i++;
	    }
	    
	    String delims = "[;]";
	    
	    String[] angle = lines[0].split(delims);
		String[] distance = lines[1].split(delims);
		
		int collision = collision_control(distance);
		if(collision==1)
		{
			//System.out.print("all good ");
		}
		else
		{
			System.out.print("collision detected ");
		}
		
		//Thread.sleep(500);
	    }
	}
	public static int collision_control (String[] input)
	{
		int sector =0, a, degree = 350, distance = 0;
		String status = "";
		String [] Sector_Status = new String[18];;
		
		while(sector<18)
		{
			a = 0;
			while(a<20)
			{
				distance = Integer.parseInt(input[degree]);
				if(distance<200 && distance>0)
				{
					status = "break";
					//System.out.print("distance detected");
				}
				
				
				if(degree==359)
				{
					degree = 0;
				}
				else
				{
					degree++;
				}
				
				
				a++;
			}
			
			Sector_Status[sector] = status;
			status = "";
			sector++;
		}
		
		a = 0;
		
		while(a<18)
		{
			if(Sector_Status[a]=="break")
			{
				return 0;
			}
			if(a==2)
			{
				a = 15;
			}
			
			a++;

		}
		return 1;
		
		
	}
	
}
