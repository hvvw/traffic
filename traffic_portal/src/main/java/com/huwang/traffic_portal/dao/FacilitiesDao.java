package com.huwang.traffic_portal.dao;

import com.huwang.traffic_portal.entity.FacilitiesEntity;
import com.huwang.traffic_portal.entity.StructureEntity;
import com.huwang.traffic_portal.util.CommonUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Transactional
@Repository("FacilitiesDao")
public class FacilitiesDao extends BaseDao {

    @Transactional
    public void deleteEntity(final Object entity) {
        super.deleteEntity(entity);
    }

    @Transactional
    public void updateEntity(final Object entity) {
        super.updateEntity(entity);
    }

    @Transactional
    public List<FacilitiesEntity> getFacilities(Double lat, Double lng, Integer unit)
    {
        if (lat!=null&&lng!=null&&unit!=null) {
            String hql="from FacilitiesEntity where lat between "+(lat-CommonUtils.ZoomTransform(unit))+" and "+(lat+CommonUtils.ZoomTransform(unit))
                    +" and lng between "+(lng-CommonUtils.ZoomTransform(unit))+" and "+(lng+CommonUtils.ZoomTransform(unit))
                    +" and display = "+true;
            Query query=currentSession().createQuery(hql);
            List<FacilitiesEntity> list = query.list();
            return list == null ? Collections.EMPTY_LIST : list;
        }
        return Collections.EMPTY_LIST;
    }
}
