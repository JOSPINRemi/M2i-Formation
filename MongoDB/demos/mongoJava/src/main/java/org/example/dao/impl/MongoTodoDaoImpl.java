package org.example.dao.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.dao.TodoDao;
import org.example.model.TodoItem;

import java.util.ArrayList;
import java.util.List;

public class MongoTodoDaoImpl implements TodoDao {
    private MongoCollection<Document> collection;

    public MongoTodoDaoImpl(MongoDatabase mongoDatabase) {
        collection = mongoDatabase.getCollection("todos");
    }

    @Override
    public void addTodo(TodoItem todoItem) {
        Document document = new Document("title", todoItem.getTitle())
                .append("description", todoItem.getDescription())
                .append("completed", todoItem.isCompleted());
        collection.insertOne(document);
    }

    @Override
    public List<TodoItem> getAllTodos() {
        List<TodoItem> todos = new ArrayList<>();
        for (Document document : collection.find()) {
            todos.add(documentToTodoItem(document));
        }
        return todos;
    }

    private TodoItem documentToTodoItem(Document document) {
        if (document == null) {
            return null;
        } else {
            TodoItem item = new TodoItem(
                    document.getObjectId("_id").toString(),
                    document.getString("title"),
                    document.getString("description"),
                    document.getBoolean("completed")
            );
            return item;
        }
    }
}
