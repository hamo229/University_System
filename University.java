public class University {
    private Student studentHead, studentTail;
    private Course courseHead, courseTail;
    private Stack undo, redo;

    public University() {
        studentHead = studentTail = null;
        courseHead = courseTail = null;
        undo = new Stack();
        redo = new Stack();
    }

    public void addStudent(int studentId) // add to tail
    {
        if (studentHead == null && studentTail == null) {
            studentHead = studentTail = new Student(studentId);
        } else {
            studentTail.next = new Student(studentId);
            studentTail = studentTail.next;
        }
    }

    public void addCourse(int courseId) // add to tail
    {
        if (courseHead == null && courseTail == null) {
            courseHead = courseTail = new Course(courseId);
        } else {
            courseTail.next = new Course(courseId);
            courseTail = courseTail.next;
        }
    }

    public void removeStudent(int studentId) {
        if (studentHead == null && studentTail == null) {
            System.out.println("NO STUDENT IN THE COURSE!!");
        } else {
            if ((studentHead == studentTail) && (studentHead.studentID == studentId)) {
                studentHead = studentTail = null;
            } else if (studentHead.studentID == studentId) {
                studentHead = studentHead.next;
            } else {
                Student pred, tmp;
                for (pred = studentHead, tmp = studentHead.next; (tmp.studentID != studentId)
                        && (tmp != null); tmp = tmp.next, pred = pred.next)
                    ;
                if (tmp != null) {
                    pred.next = tmp.next;
                    if (tmp == studentTail) {
                        studentTail = pred;
                    }
                }
            }
            System.out.println("The student of ID: " + studentId + " has removed.");
        }
        Course tmpp = courseHead;
        while (tmpp != null) {
            tmpp.removeStudent(studentId);
            tmpp = tmpp.next;
        }
    }

    public void removeCourse(int courseId) {
        if (courseHead == null && courseTail == null) {
            System.out.println("NO COURSE HAS BEEN ADDED!!");
        } else {
            if ((courseHead == courseTail) && (courseHead.courseID == courseId)) {
                courseHead = courseTail = null;
            } else if (courseHead.courseID == courseId) {
                courseHead = courseHead.next;
            } else {
                Course tmp, pred;
                for (pred = courseHead, tmp = courseHead.next; (tmp.courseID != courseId)
                        && (tmp != null); pred = pred.next, tmp = tmp.next)
                    ;
                if (tmp != null) {
                    pred.next = tmp.next;
                    if (tmp == courseTail) {
                        courseTail = pred;
                    }
                }
            }
            System.out.println("The course of ID: " + courseId + " has removed.");
        }
        Student tmpp = studentHead;
        while (tmpp != null) {
            tmpp.removeCourse(courseId);
            tmpp = tmpp.next;
        }
    }

    public int getLastStudentAdded() {
        if (studentTail != null) {
            return studentTail.studentID;
        } else {
            return -1;
        }
    }

    public int getLastCourseAdded() {
        if (courseTail != null) {
            return courseTail.courseID;
        } else {
            return -1;
        }
    }

    public void enrollmentStudent(int studentID, int courseID) {

        Course tmppC = courseHead;
        Student tmppS = studentHead;
        int ifDone = 0;
        while (tmppC != null) {
            if (tmppC.courseID == courseID) {
                if (!tmppC.isCourseInStudentList(studentID)) {
                    tmppC.addStudent(studentID);
                    ifDone = 1;
                    break;
                }
            }
            tmppC = tmppC.next;
        }
        while (tmppS != null) {
            if (tmppS.studentID == studentID) {
                if (!tmppS.isStudentInTheCourse(courseID)) {
                    tmppS.addcourse(courseID);
                    ifDone = 2;
                    break;
                }
            }
            tmppS = tmppS.next;
        }
        if (ifDone == 2) {
            undo.push(new Operation("add", tmppS, tmppC));
        }
    }

    public void removeEnrollment(int studentID, int courseID) {
        Course tmppC = courseHead;
        Student tmppS = studentHead;
        int ifDone = 0;
        while (tmppC != null) {
            if (tmppC.courseID == courseID) {
                tmppC.removeStudent(studentID);
                ifDone = 1;
                break;
            }
            tmppC = tmppC.next;
        }
        while (tmppS != null) {
            if (tmppS.studentID == studentID) {
                tmppS.removeCourse(courseID);
                ifDone = 2;
                break;
            }
            tmppS = tmppS.next;
        }
        if (ifDone == 2) {
            undo.push(new Operation("remove", tmppS, tmppC));
        }
    }

    public void listCoursesByStudent(int studentID) {
        Student tmpp = studentHead;
        while (tmpp != null) {
            if (tmpp.studentID == studentID) {
                tmpp.printLists();
                break;
            }
            tmpp = tmpp.next;
        }
    }

    public void listStudentsByCourse(int courseID) {
        Course tmpp = courseHead;
        while (tmpp != null) {
            if (tmpp.courseID == courseID) {
                tmpp.printLists();
                break;
            }
            tmpp = tmpp.next;
        }
    }

    public void sortStudentsById(int courseID) {
        Course c = courseHead;
        while (c != null && c.courseID != courseID) {
            c = c.next;
        }
        if (c != null) {
            c.sortStudentList();
            System.out.println("Students in course " + courseID + " have been sorted by ID");
        }
    }

    public void sortCourseById(int studentID) {
        Student s = studentHead;
        while (s != null && s.studentID != studentID) {
            s = s.next;
        }
        if (s != null) {
            s.sortCourseList();
            System.out.println("Courses for student " + studentID + " have been sorted by ID");
        }
    }

    public void isFullCourse(int courseID) {
        Course tmpp = courseHead;
        while (tmpp != null) {
            if (tmpp.courseID == courseID) {
                if (tmpp.isFull() == true) {
                    System.out.println("This course has Full");
                } else {
                    System.out.println("This course has not Full");
                }
                break;
            }
            tmpp = tmpp.next;
        }
    }

    public void isNormallStudent(int studentID) {
        Student tmpp = studentHead;
        while (tmpp != null) {
            if (tmpp.studentID == studentID) {
                if (tmpp.isNormall() == true) {
                    System.out.println("This student has normal");
                } else {
                    System.out.println("This student Not registers from 2 to 7 courses");
                }
                break;
            }
            tmpp = tmpp.next;
        }
    }

    public void undo() {
        if (undo.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        }
        Operation op = undo.pop();
        if (op.operation.equals("add")) {
            op.course.removeStudent(op.student.studentID);
            op.student.removeCourse(op.course.courseID);
            redo.push(new Operation("add", op.student, op.course));
        } else if (op.operation.equals("remove")) {
            op.course.addStudent(op.student.studentID);
            op.student.addcourse(op.course.courseID);
            redo.push(new Operation("remove", op.student, op.course));

        }
    }

    public void redo() {
        if (redo.isEmpty()) {
            System.out.println("Nothing to redo");
            return;
        }
        Operation op = redo.pop();
        if (op.operation.equals("add")) {
            op.course.addStudent(op.student.studentID);
            op.student.addcourse(op.course.courseID);
            undo.push(new Operation("add", op.student, op.course));
        } else if (op.operation.equals("remove")) {
            op.course.removeStudent(op.student.studentID);
            op.student.removeCourse(op.course.courseID);
            undo.push(new Operation("remove", op.student, op.course));
        }
    }
}
