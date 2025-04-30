# MiniShell Programming Exercise - אופק פרץ

## תיאור כללי של הפרויקט
בפרויקט הזה בניתי תוכנה קטנה בשפת Java שדומה לחלון הפקודות במחשב (כמו טרמינל או CMD). התוכנית מקבלת פקודות מהמשתמש ומבצעת פעולות על קבצים ותיקיות.

## הוראות כיצד לקמפל ולהריץ את הקוד
באמצעות הפקודות אפשר:

-לראות איפה אני נמצא בתוך התיקיות - `pwd`

להציג את כל הקבצים והתיקיות בתיקייה הנוכחית - `ls`

לעבור לתיקייה אחרת - `cd [dir]`

ליצור תיקייה חדשה `mkdir [dir]`

ליצור קובץ חדש `touch [file]`

לקבל עזרה עם רשימת כל הפקודות `help`

לצאת מהתוכנית `exit`


## דוגמא להרצת הפקודות
Welcome to MiniShell! Type 'help' for a list of commands.
/Users/ofek/Documents > help
Available commands:
pwd - Print the current working directory
ls - List files and directories in the current directory.
cd [dir] - Change to the specific directory (use .. to move up)
mkdir [dir] - Create new file or directory.
touch [file] - Create new empty file
help - Show this help message
exit - Exit the program

/Users/ofek/Documents > pwd
/Users/ofek/Documents

/Users/ofek/Documents > ls
[DIR] Projects
[FILE] notes.txt
[FILE] todo.txt

/Users/ofek/Documents > mkdir testFolder
Directory created: testFolder

/Users/ofek/Documents > cd testFolder

/Users/ofek/Documents/testFolder > touch hello.txt
File created: hello.txt

/Users/ofek/Documents/testFolder > ls
[FILE] hello.txt

/Users/ofek/Documents/testFolder > cd ..
/Users/ofek/Documents > exit
Goodbye!

