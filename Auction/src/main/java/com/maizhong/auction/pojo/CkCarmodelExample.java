package com.maizhong.auction.pojo;

import java.util.ArrayList;
import java.util.List;

public class CkCarmodelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CkCarmodelExample() {
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

        public Criteria andCarIdIsNull() {
            addCriterion("car_id is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("car_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(Long value) {
            addCriterion("car_id =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(Long value) {
            addCriterion("car_id <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(Long value) {
            addCriterion("car_id >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(Long value) {
            addCriterion("car_id >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(Long value) {
            addCriterion("car_id <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(Long value) {
            addCriterion("car_id <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<Long> values) {
            addCriterion("car_id in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<Long> values) {
            addCriterion("car_id not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(Long value1, Long value2) {
            addCriterion("car_id between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(Long value1, Long value2) {
            addCriterion("car_id not between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNull() {
            addCriterion("model_id is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("model_id is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(Long value) {
            addCriterion("model_id =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(Long value) {
            addCriterion("model_id <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(Long value) {
            addCriterion("model_id >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("model_id >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(Long value) {
            addCriterion("model_id <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(Long value) {
            addCriterion("model_id <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<Long> values) {
            addCriterion("model_id in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<Long> values) {
            addCriterion("model_id not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(Long value1, Long value2) {
            addCriterion("model_id between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(Long value1, Long value2) {
            addCriterion("model_id not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNull() {
            addCriterion("model_name is null");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNotNull() {
            addCriterion("model_name is not null");
            return (Criteria) this;
        }

        public Criteria andModelNameEqualTo(String value) {
            addCriterion("model_name =", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotEqualTo(String value) {
            addCriterion("model_name <>", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThan(String value) {
            addCriterion("model_name >", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("model_name >=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThan(String value) {
            addCriterion("model_name <", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThanOrEqualTo(String value) {
            addCriterion("model_name <=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLike(String value) {
            addCriterion("model_name like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotLike(String value) {
            addCriterion("model_name not like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameIn(List<String> values) {
            addCriterion("model_name in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotIn(List<String> values) {
            addCriterion("model_name not in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameBetween(String value1, String value2) {
            addCriterion("model_name between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotBetween(String value1, String value2) {
            addCriterion("model_name not between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelShornameIsNull() {
            addCriterion("model_shorname is null");
            return (Criteria) this;
        }

        public Criteria andModelShornameIsNotNull() {
            addCriterion("model_shorname is not null");
            return (Criteria) this;
        }

        public Criteria andModelShornameEqualTo(String value) {
            addCriterion("model_shorname =", value, "modelShorname");
            return (Criteria) this;
        }

        public Criteria andModelShornameNotEqualTo(String value) {
            addCriterion("model_shorname <>", value, "modelShorname");
            return (Criteria) this;
        }

        public Criteria andModelShornameGreaterThan(String value) {
            addCriterion("model_shorname >", value, "modelShorname");
            return (Criteria) this;
        }

        public Criteria andModelShornameGreaterThanOrEqualTo(String value) {
            addCriterion("model_shorname >=", value, "modelShorname");
            return (Criteria) this;
        }

        public Criteria andModelShornameLessThan(String value) {
            addCriterion("model_shorname <", value, "modelShorname");
            return (Criteria) this;
        }

        public Criteria andModelShornameLessThanOrEqualTo(String value) {
            addCriterion("model_shorname <=", value, "modelShorname");
            return (Criteria) this;
        }

        public Criteria andModelShornameLike(String value) {
            addCriterion("model_shorname like", value, "modelShorname");
            return (Criteria) this;
        }

        public Criteria andModelShornameNotLike(String value) {
            addCriterion("model_shorname not like", value, "modelShorname");
            return (Criteria) this;
        }

        public Criteria andModelShornameIn(List<String> values) {
            addCriterion("model_shorname in", values, "modelShorname");
            return (Criteria) this;
        }

        public Criteria andModelShornameNotIn(List<String> values) {
            addCriterion("model_shorname not in", values, "modelShorname");
            return (Criteria) this;
        }

        public Criteria andModelShornameBetween(String value1, String value2) {
            addCriterion("model_shorname between", value1, value2, "modelShorname");
            return (Criteria) this;
        }

        public Criteria andModelShornameNotBetween(String value1, String value2) {
            addCriterion("model_shorname not between", value1, value2, "modelShorname");
            return (Criteria) this;
        }

        public Criteria andBsxIsNull() {
            addCriterion("bsx is null");
            return (Criteria) this;
        }

        public Criteria andBsxIsNotNull() {
            addCriterion("bsx is not null");
            return (Criteria) this;
        }

        public Criteria andBsxEqualTo(Integer value) {
            addCriterion("bsx =", value, "bsx");
            return (Criteria) this;
        }

        public Criteria andBsxNotEqualTo(Integer value) {
            addCriterion("bsx <>", value, "bsx");
            return (Criteria) this;
        }

        public Criteria andBsxGreaterThan(Integer value) {
            addCriterion("bsx >", value, "bsx");
            return (Criteria) this;
        }

        public Criteria andBsxGreaterThanOrEqualTo(Integer value) {
            addCriterion("bsx >=", value, "bsx");
            return (Criteria) this;
        }

        public Criteria andBsxLessThan(Integer value) {
            addCriterion("bsx <", value, "bsx");
            return (Criteria) this;
        }

        public Criteria andBsxLessThanOrEqualTo(Integer value) {
            addCriterion("bsx <=", value, "bsx");
            return (Criteria) this;
        }

        public Criteria andBsxIn(List<Integer> values) {
            addCriterion("bsx in", values, "bsx");
            return (Criteria) this;
        }

        public Criteria andBsxNotIn(List<Integer> values) {
            addCriterion("bsx not in", values, "bsx");
            return (Criteria) this;
        }

        public Criteria andBsxBetween(Integer value1, Integer value2) {
            addCriterion("bsx between", value1, value2, "bsx");
            return (Criteria) this;
        }

        public Criteria andBsxNotBetween(Integer value1, Integer value2) {
            addCriterion("bsx not between", value1, value2, "bsx");
            return (Criteria) this;
        }

        public Criteria andQdfsIsNull() {
            addCriterion("qdfs is null");
            return (Criteria) this;
        }

        public Criteria andQdfsIsNotNull() {
            addCriterion("qdfs is not null");
            return (Criteria) this;
        }

        public Criteria andQdfsEqualTo(Integer value) {
            addCriterion("qdfs =", value, "qdfs");
            return (Criteria) this;
        }

        public Criteria andQdfsNotEqualTo(Integer value) {
            addCriterion("qdfs <>", value, "qdfs");
            return (Criteria) this;
        }

        public Criteria andQdfsGreaterThan(Integer value) {
            addCriterion("qdfs >", value, "qdfs");
            return (Criteria) this;
        }

        public Criteria andQdfsGreaterThanOrEqualTo(Integer value) {
            addCriterion("qdfs >=", value, "qdfs");
            return (Criteria) this;
        }

        public Criteria andQdfsLessThan(Integer value) {
            addCriterion("qdfs <", value, "qdfs");
            return (Criteria) this;
        }

        public Criteria andQdfsLessThanOrEqualTo(Integer value) {
            addCriterion("qdfs <=", value, "qdfs");
            return (Criteria) this;
        }

        public Criteria andQdfsIn(List<Integer> values) {
            addCriterion("qdfs in", values, "qdfs");
            return (Criteria) this;
        }

        public Criteria andQdfsNotIn(List<Integer> values) {
            addCriterion("qdfs not in", values, "qdfs");
            return (Criteria) this;
        }

        public Criteria andQdfsBetween(Integer value1, Integer value2) {
            addCriterion("qdfs between", value1, value2, "qdfs");
            return (Criteria) this;
        }

        public Criteria andQdfsNotBetween(Integer value1, Integer value2) {
            addCriterion("qdfs not between", value1, value2, "qdfs");
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