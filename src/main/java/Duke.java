import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        String[] task, taskInfo;
        Task tempTask;
        String input, command;

        System.out.println("Hola! soy José\nQué puedo hacer por ti? UwU");

        while (scanner.hasNext()) {
            try {
                input = scanner.nextLine();
                System.out.println("-------------------------------------");
                if (input.equals("bye")) {
                    System.out.println("Adiós. Espero volver a verte pronto!");
                    break;
                } else if (input.equals("list")) {
                    System.out.println("Aquí están las tareas en su lista:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println(i + 1 + ": " + tasks.get(i));
                    }
                } else {
                    task = input.split(" ", 2);
                    command = task[0];
                    if (command.equals("mark")) {
                        tempTask = tasks.get(Integer.parseInt(task[1]) - 1);
                        tempTask.mark();
                        System.out.println("¡Bonito! He marcado esta tarea como hecha:\n" + tempTask);
                    } else if (command.equals("unmark")) {
                        tempTask = tasks.get(Integer.parseInt(task[1]) - 1);
                        tempTask.unmark();
                        System.out.println("Bien, he marcado esta tarea como aún no realizada:\n" + tempTask);
                    } else if (command.equals("delete")) {
                        tempTask = tasks.get(Integer.parseInt(task[1]) - 1);
                        System.out.println("Señalado. He eliminado esta tarea:\n" + tempTask);
                        tasks.remove(tempTask);
                        System.out.println("Ahora tienes " + tasks.size() + " tareas en la lista.");
                    } else {
                        if (command.equals("todo") || command.equals("deadline") || command.equals("event")) {
                            if (task.length > 1) {
                                if (command.equals("todo")) {
                                    tempTask = new ToDo(task[1]);
                                } else if (command.equals("deadline")) {
                                    taskInfo = task[1].split(" /by ");
                                    tempTask = new Deadline(taskInfo[0], taskInfo[1]);
                                } else {
                                    taskInfo = task[1].split(" /at ");
                                    tempTask = new Event(taskInfo[0], taskInfo[1]);
                                }
                                tasks.add(tempTask);
                                System.out.println("Entendido. he añadido esta tarea:\n" + tempTask);
                            } else {
                                throw new DukeException(command + " requires additional info");
                            }
                        } else {
                            throw new DukeException("Nani?! No comprende por favor");
                        }
                        System.out.println("Ahora tienes " + tasks.size() + " tareas en la lista.");
                    }
                }
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("-------------------------------------");
        }

        scanner.close();
    }
}
