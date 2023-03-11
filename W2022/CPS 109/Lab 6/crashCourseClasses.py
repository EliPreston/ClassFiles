
class Student():
	def __init__(self, name, student_id):
		self.name = name # Typically we have the same variable names from our input to our self.var
		self.student_id = student_id
		self.is_cool = True # Notice how we don't take this in as input, but can still set this to some value. It is True cause you folks are all cool :)
		# We can have more complicated datatypes in here (and even instances of other classes!)

	# We call this an instance method (it takes in self at the very least). You'll notice something special in how we call it
	def set_name_to_bob(self):
		self.name = "bob"

	# This is a useful method, which takes in an instance of a Student (self), and a new_name, and sets that student's name to new_name
	def set_name(self, new_name):
		self.name = new_name

	# You'll notice when we traditionally print a class we don't get something nice. We can define our own "print-adjacent" method to print what we'd like
	def print_details(self):
		print("The student's name is:", self.name, "and their student id is:", self.student_id, "and their cool status is:", self.is_cool)

# Notice how this function is not within our student class (or any class). This is how we're typically used to seeing functions.
# We can call methods from within this function, or anywhere else.
def set_all_student_names_to_bob(list_of_students):
	for student in list_of_students:
		student.set_name_to_bob()

class TMUStudent(Student): # We've got something funky here (inheritance!). Very useful for Object-Oriented Programming (a way of thinking of programming). Put the parent class in brackets.
	# We can overwrite our constructor by creating a new __init__ for our child class
	def __init__(self, name, student_id):
		super().__init__(name, student_id) # We have some special syntax here, to basically call the constructor of our parent class (using super().__init__())
		# This will set self.name to name, self.student_id to student_id, AND self.is_cool to True!
		self.university_name = "TMU" # We can also have specific instance variables and methods for our child class

	# We can either have new methods...
	def enter_eng_building(self):
		print(self.name, "has successfully entered the ENG building (they are a TMU student after all!)")

	# Or we can overwrite our parent's methods
	def print_details(self):
		print("The student's name is:", self.name, "and their student id is:", self.student_id, "their cool status is:", self.is_cool, "and their university is", self.university_name)




if __name__ == "__main__":
	print("Running the main for the Class Crash Course file...")


	# Student Example #
	first_student = Student("Chris", 1234) # Again, we only pass in two things even though our constructor takes 3. That's because "self" is "first_student" here
	second_student = Student("Saghar", 4321)

	print(first_student.name) # Chris
	first_student.set_name_to_bob() # We'll set our name to bob
	print(first_student.name) # bob
	first_student.set_name("Chris K")
	print(first_student.name) # Chris K

	first_student.print_details() # Notice method syntax

	list_of_students = [first_student, second_student] # We can create lists of class instances
	set_all_student_names_to_bob(list_of_students) # And operate over them in other methods outside the class
	print(first_student.name) # bob
	print(second_student.name) # bob

	# TMUStudent Example #
	third_student = TMUStudent("Daniel", 2143)
	print(third_student.name) # Daniel
	print(third_student.is_cool) # True
	third_student.set_name("Daniel P") # Notice how this works even though we don't have a set_name method in TMUStudent?
	print(third_student.name) # Daniel P

	print(third_student.university_name) # TMU
	third_student.enter_eng_building() # Will work
	#second_student.enter_eng_building() # Will give an error as an instance of the Parent class Student does not have access to its child's methods

	third_student.print_details() # Notice how we use the new method and overwrite the old