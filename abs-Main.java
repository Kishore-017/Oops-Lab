import java.util.Scanner;

interface Stack {
    void push(String item);
    String pop();
    boolean isEmpty();
}

class ArrayStack implements Stack {
    String[] stack = new String[100];
    int top = -1;

    public void push(String item) {
        stack[++top] = item;
    }

    public String pop() {
        if (!isEmpty()) {
            return stack[top--];
        }
        return "";
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

class TextEditor {
    String text = "";
    Stack undoStack = new ArrayStack();

    public void type(String newText) {
        undoStack.push(text);
        text += newText;
    }

    public void delete(int count) {
        if (count <= text.length()) {
            undoStack.push(text);
            text = text.substring(0, text.length() - count);
        } else {
            System.out.println("Cannot delete more characters than text length.");
        }
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            text = undoStack.pop();
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void show() {
        System.out.println("Current Text: " + text);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        while (true) {
            System.out.println("\n--- Text Editor ---");
            System.out.println("1. Type Text");
            System.out.println("2. Delete Characters");
            System.out.println("3. Undo");
            System.out.println("4. Show Text");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter text to add: ");
                    String input = sc.nextLine();
                    editor.type(input);
                    break;
                case 2:
                    System.out.print("Enter number of characters to delete: "); 
                    int count = sc.nextInt();
                    editor.delete(count);
                    break;
                case 3:
                    editor.undo();
                    break;
                case 4:
                    editor.show();
                    break;
                case 5:
                    System.out.println("Exiting Text Editor...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}
