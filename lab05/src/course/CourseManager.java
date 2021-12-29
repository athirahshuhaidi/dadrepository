package course;

public class CourseManager {
	
	public Course createCourse(Course course) 
	{
		String courseCode = course.getCode().toUpperCase();
		course.setCode(courseCode);
		
		String name = course.getEnName().toUpperCase();
		course.setEnName(name);
		
		name = course.getMsName().toUpperCase();
		course.setMsName(name);
		
		int creditHour = this.getCreditHour(course.getCode());
		course.setCreditHour(creditHour);
		
		char graduateLevel = this.graduateLevel(course.getCode());
		course.setGraduateCode(graduateLevel);
		
		char degreeType = course.getCode().charAt(0);
		course.setDegreeCode(degreeType);
		
		return course;
	
	}
	
	private char graduateLevel(String code) 
	{
		char firstChar = code.charAt(0);
		
		switch (firstChar) 
		{
			case'B':
			case'D':
				return 'U';
				
			case 'M' :
			case 'P' :
				return 'P';
			
			default :
				return 'X';
		}
	}
	
	private int getCreditHour(String code) 
	{
		int creditHour = Integer.parseInt(code.substring(4,5));
		return creditHour;
	}

}
