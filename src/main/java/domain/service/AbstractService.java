package domain.service;

import domain.DataTemplate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
/**
 * Created by vpnk on 03.05.17.
 */
public class AbstractService<T extends DataTemplate>{

    private int currentId = 0;
    private List<T> db = new ArrayList<T>();

    public List<T> getAll(){
        return db;
    }
    public T get(int id){
        for(T entity: db)
            if(entity.getId() == id)
                return entity;
        return null;
    }
    public void add(T data){
        data.setId(++currentId);
        db.add(data);
    }

    public void update(T data){
        for(T entity : db)
            if(entity.getId() == data.getId()){
                data.setId(entity.getId());
                db.set(entity.getId()-1, data);
            }

    }
    public void delete(T data){
        db.remove(data);
    }

}
