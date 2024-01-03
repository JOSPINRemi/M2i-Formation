package util;

import entity.ToDo;
import entity.ToDoStatus;
import service.IToDoListService;

import java.util.List;
import java.util.Scanner;

public class IHM {
    private Scanner scanner;
    private String choice;
    private IToDoListService _toDoListService;

    public IHM(IToDoListService toDoListService) {
        scanner = new Scanner(System.in);
        _toDoListService = toDoListService;
    }

    public void start() {
        do {
            menu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    createToDo();
                    break;
                case "2":
                    showToDos();
                    break;
                case "3":
                    completeToDo();
                    break;
                case "4":
                    deleteToDo();
                    break;
            }
        } while (!choice.equals("0"));
        System.out.println("Merci d'avoir utilisé le service de gestion de ToDoList, au revoir");
    }

    private void menu() {
        System.out.println("## Menu Principal ##");
        System.out.println("1 - Ajouter une tâche à la liste");
        System.out.println("2 - Afficher toutes les tâches de la liste");
        System.out.println("3 - Marquer une tâche comme terminée");
        System.out.println("4 - Supprimer une tâche de la liste");
        System.out.println("0 - Quitter l'application");
        System.out.print("Choix : ");
    }

    private void createToDo() {
        System.out.print("Saisir le label de la ToDo : ");
        String todoLabel = scanner.nextLine();
        System.out.println("Choisir le status de la ToDo : ");
        statusMenu();
        choice = scanner.nextLine();
        ToDoStatus status;
        switch (choice) {
            case "2":
                status = ToDoStatus.COMPLETED;
                break;
            default:
                status = ToDoStatus.PENDING;
                break;
        }
        ToDo newToDo = _toDoListService.createAndSaveToDo(todoLabel, status);
        if (newToDo != null) {
            System.out.println("La ToDO a correctement été crée avec l'id " + newToDo.getId());
        } else {
            System.out.println("Problème lors de la création de la ToDo");
        }
    }

    private void statusMenu() {
        for (int i = 0; i < ToDoStatus.values().length; i++) {
            System.out.println(i+1 + " - " + ToDoStatus.values()[i]);
        }
        System.out.print("Choix : ");
    }

    private void showToDos() {
        for (ToDo toDo : _toDoListService.readToDos()) {
            System.out.println(toDo);
        }
    }

    private void completeToDo() {
        List<ToDo> todos = _toDoListService.readToDos();
        for (ToDo toDo : todos){
            if (toDo.getStatus() == ToDoStatus.PENDING){
                System.out.println(toDo);
            }
        }
        System.out.print("Saisir l'id de la ToDo à finir : ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        ToDo toDo = _toDoListService.readToDo(id);
        if (toDo != null) {
            toDo.setStatus(ToDoStatus.COMPLETED);
            _toDoListService.updateToDo(toDo);
        } else {
            System.out.println("Aucune ToDo avec l'id : " + id);
        }
    }

    private void deleteToDo() {
        _toDoListService.readToDos().forEach(System.out::println);
        System.out.print("Saisir l'id de la ToDo à supprimer : ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        _toDoListService.deleteToDo(id);
    }
}
