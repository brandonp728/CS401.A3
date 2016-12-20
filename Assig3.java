package Programs;
import java.util.*;
import java.io.*;
public class Assig3 {

	public static void main(String[] args) throws IOException {
		ArrayList<Question> qs = new ArrayList<Question>();
		Scanner userIn = new Scanner(System.in);
		int count=0, quesCount=1;
		
			int theirRightCount=0;
			int theirWrongCount=0;
			
			System.out.println("Hello! Welcome!");
			System.out.println("Choose a quiz type (history, math, english, or video games): ");
			String type = userIn.nextLine();
			type= type.toLowerCase()+".txt";
			Scanner fileRead= new Scanner(new FileInputStream(type));
			for(int j=0; j<quesCount; j++){
			String question="";
			int num=0;
			question =fileRead.nextLine();
			num= fileRead.nextInt();
			fileRead.nextLine();
			String[] ans2 = new String[num];
			for(int i=0; i<num; i++)
			{
				ans2[i] = fileRead.nextLine();
			}
			qs.add(new Question(question, num, ans2));
			qs.get(count).setRightAnswer(fileRead.nextInt());
			fileRead.nextLine();
			qs.get(count).setTimeTried(fileRead.nextInt());
			fileRead.nextLine();
			qs.get(count).setTimesCorrect(fileRead.nextInt());
			fileRead.nextLine();
			count++;
			if(fileRead.hasNext())
			{
				quesCount++;
			}
			else{
				break;
			}
		}
			
			for(int i=0; i<qs.size(); i++)
			{
				System.out.println("\nQuestion " + (i+1));
				System.out.println(qs.get(i).toString());
				System.out.print("Your answer?(Enter a number): ");
				int choice = userIn.nextInt();
				while(choice>qs.get(i).getNumOfAnswers() || choice<0)
				{
					System.out.print("Your answer?(Enter a number): ");
					choice = userIn.nextInt();
				}
				qs.get(i).setTheirAnswer(choice);
				
				
			}
			System.out.println("Thank you!\nHere are your answers:");
			for(int i=0; i<qs.size(); i++)
			{
				System.out.println("Question: " + qs.get(i).getQuestion());
				System.out.println("Answer: " + qs.get(i).getRightAnswer());
				System.out.println("Your Answer: " + qs.get(i).getTheirAnswer());
				if(qs.get(i).answerQuestion())
				{
					System.out.println("Nice job!\n");
					theirRightCount++;
					qs.get(i).updateTimeTried();
					qs.get(i).updateTimesCorrect();
				}
				else
				{
					System.out.println("Try again next time!\n");
					theirWrongCount++;
					qs.get(i).updateTimeTried();
				}
			}
			System.out.println("Overall Performance: ");
			System.out.println("Right: " + theirRightCount);
			System.out.println("Wrong:" + theirWrongCount);
			System.out.println("Percentage: " + ((double)theirRightCount/((double)(theirRightCount+theirWrongCount))*100)+ "%");
			
			System.out.println("Here are some statistics: ");
			for(int i=0; i<qs.size(); i++)
			{
				System.out.println("Question: " + (i+1));
				System.out.println("Times Tried: " + qs.get(i).getTimesTried());
				System.out.println("Times Correct: " + qs.get(i).getTimesCorrect());
				System.out.println("Percentage: " + qs.get(i).getPercentage() + "%\n");
			}
			System.out.println("Easiest question: ");
				double maxP=qs.get(0).getPercentage();
				String q=qs.get(0).getQuestion();
				int tT1=0, tC1=0; 
				for(int i=1; i<qs.size(); i++)
				{
					if(maxP<qs.get(i).getPercentage())
					{
						maxP=qs.get(i).getPercentage();
						q=qs.get(i).getQuestion();
						tT1=qs.get(i).getTimesTried();
						tC1 = qs.get(i). getTimesCorrect();
					}
				}
				System.out.println("Question: " + q);
				System.out.println("Times Tried: " + tT1);
				System.out.println("Times Correct: " + tC1);
				System.out.println("Percentage: " + maxP + "%\n");
				
				System.out.println("Hardest question: ");
					double minP=qs.get(0).getPercentage();
					String q2 = "";
					int tT2=0, tC2=0;
					for(int i=1; i<qs.size(); i++)
					{
						if(minP>qs.get(i).getPercentage())
						{
							minP=qs.get(i).getPercentage();
							q2 = qs.get(i).getQuestion();
							tT2 = qs.get(i).getTimesTried();
							tC2 = qs.get(i).getTimesCorrect();
						}
					}
					System.out.println("Question: " + q2);
					System.out.println("Times Tried: " + tT2);
					System.out.println("Times Correct: " + tC2);
					System.out.println("Percentage: " + minP + "%\n");	
					save(qs, type);
	}
	public static void save(ArrayList<Question> a, String fName) throws IOException
	{
		String[] back2TheFile = new String[a.size()];
		PrintWriter writer = new PrintWriter(fName);
		for(int i=0; i<a.size(); i++)
		{
			writer.println(a.get(i).getQuestion());
			writer.println(a.get(i).getNumOfAnswers());
			writer.println(a.get(i).getAnswers2());
			writer.println(a.get(i).getRightAnswer2());
			writer.println(a.get(i).getTimesTried());
			writer.println(a.get(i).getTimesCorrect());
		}
		writer.close();
		
		
		
	}

}
