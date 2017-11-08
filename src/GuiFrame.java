
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author TAYLOR PLAMBECK
 */
public class GuiFrame extends javax.swing.JFrame {
	                  //declare file name and default gui message
	static String TxtFileName="C:\\Users\\Taylor\\workspace\\Q3GUI\\ClassList.txt";
	
	static String message="Search By: \n - ECE course number\n - Instructor's Exact Name or the Letter of their First Name\n - Any word in the Class Title"
			+ "\n\n\nWant to search the TextFile instead? "
			+ "\nType 'file' into the 'Course Number' box and Press 'Search'.  This loads the classes from the .txt file for you to search from."
			+ "\n(Class Names from the .txt file have the word (TextFile) added to them for differentiation.)\nNote: The .txt filepath is declared at the first line of the program. ";
	
   //this first line does nothing.
	private static final long serialVersionUID = 1L;
	public javax.swing.JButton ClearButt;
    public static javax.swing.JTextField CourseBox;
    public javax.swing.JComboBox<String> InstMultBox;
    public static javax.swing.JTextField InstructorBox;
    public static javax.swing.JTextField KeywordBox;
    public javax.swing.JButton SearchButt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane scroller;
    public javax.swing.JTextArea TxtArea;
    static String InstInput="";
    static String CourseInput="";
    static String KeywordInput="";
    static int alreadySearched=0;
    static int test=1;
    
            
	//we have just a string for meetdate cause all dates are the same. 
	//34 classses, put into Teachers, DateTime,CourseName and COurse NUmber. We also have the Class number for the individual sections.
	//the string arrays are simply the name of teacher or class. the date and time are in the form Day:dd, Time:ttPM, R represents thuRsday lul
    //for teh txt file, WE NEED TO MAKE THE ARRAYS FROM THE .TXT FILE ITSELF, THEN PASS IT AS NORMAL. NO CHANGE TO THE PROGRAM.
    
    //THESE ARE THE ARRAYS OF CLASSES FOR THE 3rd PROBLEM. FOR NUMBERR 4 WITH THE TXT FILE, READ THE GUI.
	static String MeetDate="Meet Dates: 06/20/2016 - 08/25/2016";		
		
	static String[] TeacherAry = new String[]{"Zekeriya Aliyazicioglu","Hong-Chuan Lin","Rajan Chandra","Saeed Monemi","Brita Olson",
			"Brita Olson","Saeed Monemi","Saeed Monemi","Hong-Chuan Lin","Saeed Monemi","Sumanth Nandikanti","Saeed Monemi","Sumanth Nandikanti",
			"Saeed Monemi","James Kang","James Kang","Zekeriya Aliyazicioglu","Rajan Chandra","Hong-Chuan Lin","Brita Olson","Brita Olson",
			"Brita Olson","Mohamed Rafiquzzaman","Rajan Chandra","Mohamed Rafiquzzaman","Tarek Elsharhawy","Mohamed Rafiquzzaman",
			"Mohamed Rafiquzzaman","Mohamed Rafiquzzaman","Adrian Gonzalez","Zekeriya Aliyazicioglu","James Kang","Hong-Chuan Lin","James Kang"
	};	
	static String[] DateTimeAry = new String[]{"Day:MW, Time:8-9:15AM","Day:R, Time:12-2:50PM","Day:MW, Time:6-7:15PM",
			"Day:T, Time:9-11:50AM","Day:MW, Time:10-11:15AM","Day:R, Time:3-5:50PM","Day:MW, Time:10-11:15AM",
			"Day:MW, Time:8-9:15AM","Day:TR, Time:10-11:15AM","Day:M, Time:12-2:50PM","Day:T, Time:12-2:50PM","Day:W, Time:12-2:50PM",
			"Day:R, Time:3-5:50PM","Day:MW, Time:4-5:50PM","Day:TR, Time:8-9:50AM","Day:TR, Time:10-11:50AM",
			"Day:T, Time:3-5:50PM","Day:MW, Time:2-3:50PM","Day:TR, Time:6-7:50PM","Day:MW, Time:4-5:15AM",
			"Day:T, Time:12-2:50PM","Day:MW, Time:12-1:15PM","Day:MW, Time:12-1:15PM","Day:MW, Time:8-9:15AM",
			"Day:T, Time:3-5:50PM","Day:T, Time:3-5:50PM","Day:MW, Time:2-3:50PM","Day:MW, Time:4-5:50PM",
			"Day:T, Time:12-2:50PM","Day:T, Time:12-2:50PM","Day:MW, Time:10-11:50AM","Day:MW, Time:6-7:15PM",
			"Day:MW, Time:4-5:50PM","Day and Time TBA"	};	
			
	static String[] CourseNameAry = new String[]{"Network Analysis I","Network Analysis I LAB","Network Analysis II","Network Analysis II LAB",
			"Electronic Devices and Circuits","Electronics LAB","Elements of Electrical Engineering","Elements of Electrical Engineering",
			"Elements of Electrical Engineering","Elements of Electrical Engineering LAB","Elements of Electrical Engineering LAB","Elements of Electrical Engineering LAB",
			"Elements of Electrical Engineering LAB","Object Oriented Programming","Electromagnetic Fields","Discrete Time Signals","Discrete Time Signals Lab",
			"Control Systems Engineering","Probablity Statistics and Random Processes","Electronic Design of Digital Circuits",		
			"Electronic Design of Digital Circuits LAB","Intro to SemiConductor Devices","Intro to Microcontrollers","Intro to Microcontrollers","Intro to Microcontrollers LAB",
			"Intro to Microcontrollers LAB","Microcontrollers I","Microcontrollers I","Microcontrollers I LAB",
			"Microcontrollers I LAB","Communcation Systems","Digital Signal Processing","Application Development with JAVA",
			"Communication Theory"		};
	
	static String[] ClassNumAry = new String[]{"50697","50698","50699","50700","50702","50845","50703","50704"
			,"50968","50705","50706","50969","50970","50707","50708","50709","50710","50712","50713","50715","50716","50717","50718",
			"51011","50719","51012","50720","50932","50721","50943","50722","50723","50724","50829"	};
	static String[] CourseNumAry = new String[]{"207","207","209","209","220","220","231","231","231","231","231","231","231","256","302","306","306","309",
			"315","325","325","330","341","341","341","341","343","343","343","343","405","408","429","544"	};
	static int[] matchAry=new int [40];
	static int[] matchAry2=new int [40];
	static int[] matchAry3=new int [40];
	static int ClassCount=34;
	static int InstructorMatches=0;
	static int CourseMatches=0;
	static int txtFileCounter=0;
	
    public GuiFrame() 
    {
    	//this sets up the gui display, @ botton of program
        initComponents();
   //this prints all 34 classses   
        
        for(int x=0;x<ClassCount;x++)	//prints out every class to the console, grabbed from the arrays above.
        {
   //     System.out.println("ECE "+CourseNumAry[x]+" "+CourseNameAry[x]);
    //    System.out.println("Class#: "+ClassNumAry[x]+" Teacher: "+TeacherAry[x]+"      "+DateTimeAry[x]+"  "+MeetDate);
      //  	System.out.println("Total Number of Classes: "+ClassCount);
        }
        	
    		
    	
    }
    
    private void SearchButtActionPerformed(java.awt.event.ActionEvent evt) {                                           
        CourseMatches=0;	//reset match counters
        InstructorMatches=0;
    	ArrayCleaner();	//reset arrays
    	InstructorMatches=0;
    	CourseMatches=0;
    	InstInput=InstructorBox.getText();	//grab the text from the textfields from the user.
        CourseInput=CourseBox.getText();
        KeywordInput=KeywordBox.getText();
        SearchChooser();//call searcherchooser below to see what parameter the user wants to search by
        
    }                                          
    public void SearchChooser()	//this is the function that searches the arrays, if you want to add the .txt or MYSQL search, make a different one and call it above.
    {    	        
    	if(CourseInput.toUpperCase().contains("file".toUpperCase()))
    	{
    	
    	ArrayMaker();	//if we typed in file to course number box, then we want to load the .txt file instead of using the arrays above. this calls that fxn
    	}
    	if(InstInput.length()>0)	//these 3 if's check if we typed in anything in any of the text fields and searches accordingly.
    	{
    		SearchInstructors();
    		alreadySearched=1;
    	}
    	if(CourseInput.length()>0)
    	{
    		SearchCourses();
    		alreadySearched=2;
    	}
    	if (KeywordInput.length()>0)
    	{
    		SearchClassNames();
    		//when we search for the class names, we are going to check if there has been searches already, and we will grab previously matched arrays instead
    		//of the starting arrays.
    	}    	
    	alreadySearched=0;	//set default for next search.
    }
    
    
    public void SearchInstructors() //search instructor, always pulled from starting array. however, there is a choice of whether it is searched by starting letter or by exact name.
    {
		//pull arrays from beginning.
    	int matchCount=0;
		System.out.println("Searchinstructorss only");
		if(InstMultBox.getSelectedItem().equals("begins with"))
		{
			//System.out.print(InstMultBox.getSelectedItem());
			for(int q=0;q<ClassCount;q++)
			{
				if(TeacherAry[q].toUpperCase().startsWith(InstInput.toUpperCase()))
				{
					matchAry[matchCount++]=q;
				}
			}	
				InstructorMatches=matchCount;
			PrintResults(matchCount,1);
		}
		else if(InstMultBox.getSelectedItem().equals("is exactly"))
		{
			//System.out.print(InstMultBox.getSelectedItem());
			for(int q=0;q<ClassCount;q++)
			{
				if(TeacherAry[q].toUpperCase().equals(InstInput.toUpperCase()))
				{
					matchAry[matchCount++]=q;
				}
			}	
			InstructorMatches=matchCount;	
			PrintResults(matchCount,1);
		}
	
		//store in match array.
	}
    
    public void SearchCourses() //searches course numbers. if we have already searched instructors we pulll their matches instead of the original arrays.
    {
		int matchCount=0;
		if(alreadySearched==1)
		{
			//pull arrays from matchAry and further narrow down, then store results on matchAry2.
			System.out.println("SearchCourses, typed something in instruct.");
			
			for(int q=0;q<InstructorMatches;q++)
			{
				System.out.print(InstructorMatches);
				//match array holds 4 classses.matchAry={1,8,18,32}
				
				if(CourseNumAry[matchAry[q]].equals(CourseInput))
				{
					matchAry2[matchCount++]=matchAry[q];
				}
			}	
			CourseMatches=matchCount;
			PrintResults(matchCount,2);
			}			
		else
		{	
			System.out.println("SearchCourses only");
			//else pull arrays from beginning, store in matchAry2
			//searchCourseNum array	
			for(int q=0;q<ClassCount;q++)
			{
				if(CourseNumAry[q].equals(CourseInput))
				{
					matchAry2[matchCount++]=q;
				}
			}	
			CourseMatches=matchCount;
			PrintResults(matchCount,2);
		}	
		}

    public void SearchClassNames() 	//searches class names for keyword. if we have already searched instructors or course numbers, we pulll their matches instead of the original arrays.
    {
    	int matchCount=0;
    	if(alreadySearched==2)
		{
			//pull arrays from matchAry2, store results in matchAry3.
			System.out.println("searchkeyword, typed something in courses.");
			
			for(int q=0;q<CourseMatches;q++)
			{
				System.out.print(CourseMatches);
				//match array holds 4 classses.matchAry={1,8,18,32}
				
				if(CourseNameAry[matchAry2[q]].toUpperCase().contains(KeywordInput.toUpperCase()))
				{
					matchAry3[matchCount++]=matchAry2[q];
				}
			}	
				PrintResults(matchCount,3);

		}
		else if(alreadySearched==1)
		{
			//pull arrays from matchAry, store results in matchAry3.
			
			System.out.println("Searchkeyword, typed something in instructors.");
			
			for(int q=0;q<InstructorMatches;q++)
			{
				System.out.print(InstructorMatches);
				//match array holds 4 classses.matchAry={1,8,18,32}
				
				if(CourseNameAry[matchAry[q]].toUpperCase().contains(KeywordInput.toUpperCase()))
				{
					matchAry3[matchCount++]=matchAry[q];
				}
			}	
				PrintResults(matchCount,3);
		}
		else 
		{
			//pull arrays from beginning. stores in matchary3
			System.out.println("Searchkeyword only");
			for(int q=0;q<ClassCount;q++)
			{
				if(CourseNameAry[q].toUpperCase().contains(KeywordInput.toUpperCase()))
				{
					matchAry3[matchCount++]=q;
				}
			}	
				PrintResults(matchCount,3);

		}
		
	}
    public void ArrayMaker()
    {
    	for(int y=0;y<ClassCount;y++)	//deletes the hardcoding of the class data in the several arrays that house them
    	{
    		ClassNumAry[y]="";
    		TeacherAry[y]="";
    		CourseNumAry[y]="";
    		DateTimeAry[y]="";
    		CourseNameAry[y]="";
    	}
    	
    	@SuppressWarnings("resource")
		Scanner txtscan = null;
		try {
			txtscan = new Scanner(new File(TxtFileName));	//make a new file input, declared in line 1 of program.
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	while(txtscan.hasNextLine()){	//while there is still another line to read, read the line and save it into a string. send the string over to the matcher.
    	    String str = txtscan.nextLine();
    	        StringMatcher(str);
    	        test++;   		//this keeps track of what line we are at. .txt file is set up to have a class every two lines, which means we need to save data accordingly.
    	        
    	}  
    	
    	txtFileCounter=0;
    }
    
      public void StringMatcher(String input)	//this is a long function that searches for different words in the .txt file to find the indexes of the data needed to fill the arrays.
      {
      	int siCourse=0;
      	int eiCourse=0;
      	int siDay=0;
      	int eiDay=0;
      	int siClass=0;
      	int eiClass=0;
      	int siTeacher=0;
      	int eiTeacher=0;
      	int siTitle=0;
      	int eiTitle=0;
 //------------------------------------------------------------------------------------------------------------------------------------          

      		String wordToFind = "ECE";
          Pattern word = Pattern.compile(wordToFind);	//this is a handy little word matcher, gives the index of a match with our wordtoFind
          Matcher match = word.matcher(input);
          while (match.find()) 
          {
            siCourse= (match.end()+1);
            eiCourse=siCourse+3;
            siTitle=eiCourse+1;
          }
 //------------------------------------------------------------------------------------------------------------------------------------          
          wordToFind = "Meet";	//this searches for the word Time, in our DateTimeAry list. CAPITALS MATTER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         word = Pattern.compile(wordToFind);	//this is a handy little word matcher, gives the index of a match with our wordtoFind
         match = word.matcher(input);
          while (match.find()) 
          {
          	eiDay=match.start()-2;
          }
 //------------------------------------------------------------------------------------------------------------------------------------          
         
          wordToFind = "Day";	
          word = Pattern.compile(wordToFind);	//this is a handy little word matcher, gives the index of a match with our wordtoFind
          match = word.matcher(input);
           while (match.find()) 
           {
            siDay=match.start();
            eiTeacher=match.start()-6;
           }
 //------------------------------------------------------------------------------------------------------------------------------------          
           wordToFind = "Teacher";	
           word = Pattern.compile(wordToFind);	//this is a handy little word matcher, gives the index of a match with our wordtoFind
           match = word.matcher(input);
            while (match.find()) 
            {
            	siTeacher=(match.end()+2);
            	eiClass=match.start()-1;
            }
//------------------------------------------------------------------------------------------------------------------------------------          
             wordToFind = "Class";	
             word = Pattern.compile(wordToFind);	//this is a handy little word matcher, gives the index of a match with our wordtoFind
             match = word.matcher(input);
              while (match.find()) 
              {
            	  siClass=(match.end()+3);
              }          
          eiTitle=input.length();
         
              if(test%2==0)
              {
             	 //save classnumber and teacher and day and time.
             	String DayTime=input.substring(siDay, eiDay);
             	System.out.println(DayTime);
             	String Teacher=input.substring(siTeacher, eiTeacher);
             	System.out.println(Teacher);
             	String Class=input.substring(siClass, eiClass);
             	System.out.println(Class);
             	
             	DateTimeAry[txtFileCounter]=DayTime;
             	TeacherAry[txtFileCounter]=Teacher;
             	 ClassNumAry[txtFileCounter]=Class;
             	 
             	txtFileCounter++;	//this is the magic piece that allows you to save all the data from two lines, then increases the count. increases after two lines because 
             						//txt file is set up with a class taking up two lines over and over. 
              }
              else
              {
             	 //save course title and course number. taken from the first line of the textfile.
             	String Course=input.substring(siCourse, eiCourse);
                System.out.print("course num: "+Course);
                String Title=input.substring(siTitle, eiTitle);
             	System.out.println(Title);
             	
             	CourseNumAry[txtFileCounter]=Course;
          		CourseNameAry[txtFileCounter]=Title;
          		
              }       
      }    

	private void ClearButtActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // resets everything.
    	 InstructorBox.setText("");
    	 KeywordBox.setText("");
    	 CourseBox.setText("");
         TxtArea.setText(message);
    	 ArrayCleaner();
    	 }             

    /*
    \t  Insert a tab in the text at this point.
    \b  Insert a backspace in the text at this point.
    \n  Insert a newline in the text at this point.
    \r  Insert a carriage return in the text at this point.
    \f  Insert a formfeed in the text at this point.
    \'  Insert a single quote character in the text at this point.
    \"  Insert a double quote character in the text at this point.
    \\  Insert a backslash character in the text at this point.
         */
	
    public void PrintResults(int matches, int recieved)
    {
		TxtArea.setText("Results:");
    	int w =0;
    	for(int r =0;r<matches;r++)
		{
			if(recieved==2)
			{
				w=matchAry2[r];
			}
			else if (recieved==1)
				{w=matchAry[r];}
			else if (recieved==3)
			{w=matchAry3[r];}
		    
				TxtArea.append("\nECE "+CourseNumAry[w]+" - "+CourseNameAry[w]);
		        TxtArea.append("\nClass#: "+ClassNumAry[w]);
		        TxtArea.append("\tTeacher: "+TeacherAry[w]+"\t"+DateTimeAry[w]+"\t"+MeetDate+"\n");     
		}	
    }
    
    public void ArrayCleaner()	//this is just to reset the matcharrays
    {
    	for(int k=0;k<ClassCount;k++)
    	{
    		matchAry[k]=0;
    		matchAry2[k]=0;
    		matchAry3[k]=0;
    	}
    }
    
    public static void main(String args[]) 
    {
        //main simply sets up the frame and adds the GUI, everything else is in class
      GuiFrame newFrame =   new GuiFrame(); 
      newFrame.setDefaultCloseOperation(  JFrame.EXIT_ON_CLOSE );
      newFrame.setTitle("Class Finder - Cal Poly Pomona ECE Department");
      newFrame.setSize(1150,700); // set frame size
      newFrame.setVisible( true ); // display frame
    }
     //layout for GUI below:
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        CourseBox = new javax.swing.JTextField();
        InstructorBox = new javax.swing.JTextField();
        KeywordBox = new javax.swing.JTextField();
        InstMultBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ClearButt = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        SearchButt = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        TxtArea = new javax.swing.JTextArea();
        scroller = new JScrollPane(TxtArea);	//in order to make the txtarea scroll, just add the area to the scrollerpane.
        										//down in the initcopmonents, we switch out TxtArea with scroller, and we are good to go.

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        InstructorBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstructorBoxActionPerformed(evt);
            }

			private void InstructorBoxActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				
			}
        });

        InstMultBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "begins with", "is exactly" }));

        jLabel1.setText("Course Number");

        jLabel2.setText("Instructor Name");

        jLabel3.setText("Course Keywords");

        ClearButt.setText("Clear");
        
        ClearButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtActionPerformed(evt);
            }
        });

        jLabel4.setText("Search By");

        SearchButt.setText("Search!");
        SearchButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtActionPerformed(evt);
            }
        });

        jLabel5.setText("ECE Classes for Summer 2016");

        TxtArea.setText(message);
   //	 TxtArea.append("\nSearch is CASE-SENSITIVE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(37, 37, 37)
                .addComponent(InstMultBox, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KeywordBox)
                    .addComponent(CourseBox)
                    .addComponent(InstructorBox, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(72, 72, 72))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SearchButt)
                        .addGap(18, 18, 18)
                        .addComponent(ClearButt))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scroller)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(150, 150, 150)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CourseBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InstructorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(InstMultBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KeywordBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClearButt)
                    .addComponent(SearchButt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroller, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        
   
}	//end class
