package Programs;
public class Question {
	
	private String question;
	private int numOfAnswers, rightAnswer, timesTried, timesCorrect, theirAnswer;
	private String[] answers;
	
	public Question(String q, int num, String[] a)
	{
		question=q;
		numOfAnswers=num;
		answers = a;
	}
	public void setQuestion(String q)
	{
		question = q;
	}
	
	public void setArraySize(int a)
	{
		answers = new String[numOfAnswers];
	}
	
	public void updateTimeTried()
	{
		timesTried++;
	}
	
	public void updateTimesCorrect()
	{
		timesCorrect++;
	}
	
	public void setTimeTried(int tT)
	{
		timesTried=tT;
	}
	
	public void setRightAnswer(int rA)
	{
		rightAnswer=rA;
	}
	
	public void setTimesCorrect(int tC)
	{
		timesCorrect=tC;
	}
	
	public void setAnswers(String[] a)
	{
		answers=a;
	}
	
	public void setTheirAnswer(int a)
	{
		theirAnswer=a;
	}
	
	public int getNumOfAnswers()
	{
		return numOfAnswers;
	}
	
	public int getTimesTried()
	{
		return timesTried;
	}
	
	public int getTimesCorrect()
	{
		return timesCorrect;
	}
	
	public double getPercentage()
	{
		double tC = (double)timesCorrect, tT = (double)timesTried, percentage;
		percentage  = (tC/tT)*100;
		return percentage;
	}
	
	public String getQuestion()
	{
		return question;
	}
	
	
	public String getAnswers()
	{
		String str="";
		for(int i=0; i<answers.length; i++)
		{
			str+=i+ ": " + answers[i] + "\n";	
		}
		return str;
	}
	
	public String getAnswers2()
	{
		String str="";
		for(int j=0; j<answers.length; j++)
		{
			str+=answers[j] + "\n";	
		}
		return str;
	}
	
	public int getRightAnswer2()
	{
		return rightAnswer;
	}
	
	public String getRightAnswer()
	{
		return answers[rightAnswer];
	}
	
	public String getTheirAnswer()
	{
		return answers[theirAnswer];
	}
	
	public boolean answerQuestion()
	{
		if(theirAnswer==rightAnswer)
		{
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		String str = question + "\nAnswers:\n";
		for(int i=0; i<answers.length; i++)
		{
			str+=i+ ": " + answers[i];
			if(i<answers.length)
			{
				str+="\n";
			}
		}
		return str;
		
	}
	
	public String toFile()
	{
		String str = question + "\n";
		for(int i=0; i<answers.length; i++)
		{
			str+=answers[i];
			if(i<answers.length)
			{
				str+="\n";
			}
			str+="\n" + rightAnswer + "\n" + timesTried + "\n" + timesCorrect + "\n";
		}
		return str;
		
	}
	
}
