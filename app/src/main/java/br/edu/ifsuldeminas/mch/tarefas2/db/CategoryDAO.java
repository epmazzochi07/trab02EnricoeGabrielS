package br.edu.ifsuldeminas.mch.tarefas2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsuldeminas.mch.tarefas2.domain.Category;

public class CategoryDAO extends DAO<Category> {

    public CategoryDAO(Context context){
        super(context);
    }

    @Override
    public void save(Category entity) {
        SQLiteDatabase database = openToWrite();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", entity.getName());

        database.insert("categories", null, contentValues);

        database.close();
    }

    @Override
    public void update(Category entity) {
        SQLiteDatabase database = openToWrite();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", entity.getName());

        String[] params = {entity.getId().toString()};
        database.update("categories", contentValues,
                "id = ?", params);

        database.close();
    }

    @Override
    public void delete(Category entity) {
        SQLiteDatabase database = openToWrite();

        String[] params = {entity.getId().toString()};
        database.delete("categories", " id = ? ", params);

        database.close();
    }

    @Override
    public List<Category> listAll() {
        SQLiteDatabase database = openToRead();
        List<Category> categories = new ArrayList<>();

        String sql = " SELECT * FROM categories ";

        Cursor cursor = database.rawQuery(sql, null);

        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String name = cursor.getString(
                    cursor.getColumnIndexOrThrow("name"));
            Category category = new Category(id, name);
            categories.add(category);
        }

        cursor.close();
        database.close();

        return categories;
    }
}
