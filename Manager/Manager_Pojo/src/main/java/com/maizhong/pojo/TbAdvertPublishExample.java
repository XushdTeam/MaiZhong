package com.maizhong.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbAdvertPublishExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbAdvertPublishExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }
//测试开始
        public  Criteria andAdvertTypeEqualTo(Integer value){
            if (value != null) {
                addCriterion("p.advert_id=t.id and t.advert_type= ",value,"advertType");
            }else {
                addCriterion("p.advert_id=t.id ");
            }

            return (Criteria) this;
        }
        //测试结束

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAdvertIdIsNull() {
            addCriterion("advert_id is null");
            return (Criteria) this;
        }

        public Criteria andAdvertIdIsNotNull() {
            addCriterion("advert_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertIdEqualTo(Long value) {
            addCriterion("advert_id =", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdNotEqualTo(Long value) {
            addCriterion("advert_id <>", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdGreaterThan(Long value) {
            addCriterion("advert_id >", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdGreaterThanOrEqualTo(Long value) {
            addCriterion("advert_id >=", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdLessThan(Long value) {
            addCriterion("advert_id <", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdLessThanOrEqualTo(Long value) {
            addCriterion("advert_id <=", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdIn(List<Long> values) {
            addCriterion("advert_id in", values, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdNotIn(List<Long> values) {
            addCriterion("advert_id not in", values, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdBetween(Long value1, Long value2) {
            addCriterion("advert_id between", value1, value2, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdNotBetween(Long value1, Long value2) {
            addCriterion("advert_id not between", value1, value2, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertTimeIsNull() {
            addCriterion("advert_time is null");
            return (Criteria) this;
        }

        public Criteria andAdvertTimeIsNotNull() {
            addCriterion("advert_time is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertTimeEqualTo(Date value) {
            addCriterion("advert_time =", value, "advertTime");
            return (Criteria) this;
        }

        public Criteria andAdvertTimeNotEqualTo(Date value) {
            addCriterion("advert_time <>", value, "advertTime");
            return (Criteria) this;
        }

        public Criteria andAdvertTimeGreaterThan(Date value) {
            addCriterion("advert_time >", value, "advertTime");
            return (Criteria) this;
        }

        public Criteria andAdvertTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("advert_time >=", value, "advertTime");
            return (Criteria) this;
        }

        public Criteria andAdvertTimeLessThan(Date value) {
            addCriterion("advert_time <", value, "advertTime");
            return (Criteria) this;
        }

        public Criteria andAdvertTimeLessThanOrEqualTo(Date value) {
            addCriterion("advert_time <=", value, "advertTime");
            return (Criteria) this;
        }

        public Criteria andAdvertTimeIn(List<Date> values) {
            addCriterion("advert_time in", values, "advertTime");
            return (Criteria) this;
        }

        public Criteria andAdvertTimeNotIn(List<Date> values) {
            addCriterion("advert_time not in", values, "advertTime");
            return (Criteria) this;
        }

        public Criteria andAdvertTimeBetween(Date value1, Date value2) {
            addCriterion("advert_time between", value1, value2, "advertTime");
            return (Criteria) this;
        }

        public Criteria andAdvertTimeNotBetween(Date value1, Date value2) {
            addCriterion("advert_time not between", value1, value2, "advertTime");
            return (Criteria) this;
        }

        public Criteria andAdvertSortIsNull() {
            addCriterion("advert_sort is null");
            return (Criteria) this;
        }

        public Criteria andAdvertSortIsNotNull() {
            addCriterion("advert_sort is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertSortEqualTo(Integer value) {
            addCriterion("advert_sort =", value, "advertSort");
            return (Criteria) this;
        }

        public Criteria andAdvertSortNotEqualTo(Integer value) {
            addCriterion("advert_sort <>", value, "advertSort");
            return (Criteria) this;
        }

        public Criteria andAdvertSortGreaterThan(Integer value) {
            addCriterion("advert_sort >", value, "advertSort");
            return (Criteria) this;
        }

        public Criteria andAdvertSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("advert_sort >=", value, "advertSort");
            return (Criteria) this;
        }

        public Criteria andAdvertSortLessThan(Integer value) {
            addCriterion("advert_sort <", value, "advertSort");
            return (Criteria) this;
        }

        public Criteria andAdvertSortLessThanOrEqualTo(Integer value) {
            addCriterion("advert_sort <=", value, "advertSort");
            return (Criteria) this;
        }

        public Criteria andAdvertSortIn(List<Integer> values) {
            addCriterion("advert_sort in", values, "advertSort");
            return (Criteria) this;
        }

        public Criteria andAdvertSortNotIn(List<Integer> values) {
            addCriterion("advert_sort not in", values, "advertSort");
            return (Criteria) this;
        }

        public Criteria andAdvertSortBetween(Integer value1, Integer value2) {
            addCriterion("advert_sort between", value1, value2, "advertSort");
            return (Criteria) this;
        }

        public Criteria andAdvertSortNotBetween(Integer value1, Integer value2) {
            addCriterion("advert_sort not between", value1, value2, "advertSort");
            return (Criteria) this;
        }




    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}