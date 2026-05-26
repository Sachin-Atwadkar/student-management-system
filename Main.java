import mysql.connector

# ===== DATABASE CONNECTION =====
conn = mysql.connector.connect(
    host="localhost",
    user="root",
    password="Sachin@2004",   # change this
    database="college"
)

cursor = conn.cursor()


# ===== FUNCTIONS =====

def add_student():
    name = input("Enter name: ")
    age = int(input("Enter age: "))
    city = input("Enter city: ")

    sql = "INSERT INTO students (name, age, city) VALUES (%s, %s, %s)"
    values = (name, age, city)

    cursor.execute(sql, values)
    conn.commit()

    print("Student added successfully!")


def view_students():
    cursor.execute("SELECT * FROM students")
    results = cursor.fetchall()

    print("\n===== STUDENT LIST =====")
    for row in results:
        print(row)


def update_student():
    student_id = int(input("Enter student ID to update: "))
    name = input("Enter new name: ")
    age = int(input("Enter new age: "))
    city = input("Enter new city: ")

    sql = "UPDATE students SET name=%s, age=%s, city=%s WHERE id=%s"
    values = (name, age, city, student_id)

    cursor.execute(sql, values)
    conn.commit()

    print("Student updated successfully!")


def delete_student():
    student_id = int(input("Enter student ID to delete: "))

    sql = "DELETE FROM students WHERE id=%s"
    values = (student_id,)

    cursor.execute(sql, values)
    conn.commit()

    print("Student deleted successfully!")


# ===== MENU =====

while True:
    print("\n===== STUDENT MANAGEMENT SYSTEM =====")
    print("1. Add Student")
    print("2. View Students")
    print("3. Update Student")
    print("4. Delete Student")
    print("5. Exit")

    choice = input("Enter choice: ")

    if choice == "1":
        add_student()

    elif choice == "2":
        view_students()

    elif choice == "3":
        update_student()

    elif choice == "4":
        delete_student()

    elif choice == "5":
        print("Exiting system...")
        break

    else:
        print("Invalid choice!")
