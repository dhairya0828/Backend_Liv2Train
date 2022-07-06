package com.senpiper.liv2train2.repository;

import com.senpiper.liv2train2.model.TrainingCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class CustomTrainingCenterRepositoryImpl implements CustomTrainingCenterRepository{


    private @Autowired MongoTemplate mongoTemplate;

    @Override
    public List<TrainingCenter> findCenterByParams(Map<String, String> params) {

        final Query query = new Query();

        for(Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (Objects.equals(key, "studentCapacity"))
                query.addCriteria(Criteria.where("studentCapacity").is(Integer.parseInt(value)));

            else if(Objects.equals(key, "pincode") || Objects.equals(key, "city") || Objects.equals(key, "state"))
                query.addCriteria(Criteria.where("address."+key).is(value));

            else if(Objects.equals(key, "course"))
                query.addCriteria(Criteria.where("courses").regex(".*" + value + ".*", "i"));

            else if(Objects.equals(key, "created before") || Objects.equals(key, "created after")){
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date date = null;

                try {
                    date = sdf.parse(value);
                } catch (ParseException e) {
                    throw new RuntimeException("Invalid Date Format, Valid Format: dd/MM/yyyy");
                }
                if((Objects.equals(key, "created before")))
                    query.addCriteria(Criteria.where("createdOn").lt(date.getTime()));
                else
                    query.addCriteria(Criteria.where("createdOn").gt(date.getTime()));
            }

            else
                query.addCriteria(Criteria.where(key).is(value));
        }
        return mongoTemplate.find(query, TrainingCenter.class);
    }
}
