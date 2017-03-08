package com.maizhong.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbAdvertExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbAdvertExample() {
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

        public Criteria andAdvertNameIsNull() {
            addCriterion("advert_name is null");
            return (Criteria) this;
        }

        public Criteria andAdvertNameIsNotNull() {
            addCriterion("advert_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertNameEqualTo(String value) {
            addCriterion("advert_name =", value, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameNotEqualTo(String value) {
            addCriterion("advert_name <>", value, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameGreaterThan(String value) {
            addCriterion("advert_name >", value, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameGreaterThanOrEqualTo(String value) {
            addCriterion("advert_name >=", value, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameLessThan(String value) {
            addCriterion("advert_name <", value, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameLessThanOrEqualTo(String value) {
            addCriterion("advert_name <=", value, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameLike(String value) {
            addCriterion("advert_name like", value, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameNotLike(String value) {
            addCriterion("advert_name not like", value, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameIn(List<String> values) {
            addCriterion("advert_name in", values, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameNotIn(List<String> values) {
            addCriterion("advert_name not in", values, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameBetween(String value1, String value2) {
            addCriterion("advert_name between", value1, value2, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameNotBetween(String value1, String value2) {
            addCriterion("advert_name not between", value1, value2, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlIsNull() {
            addCriterion("advert_url is null");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlIsNotNull() {
            addCriterion("advert_url is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlEqualTo(String value) {
            addCriterion("advert_url =", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlNotEqualTo(String value) {
            addCriterion("advert_url <>", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlGreaterThan(String value) {
            addCriterion("advert_url >", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlGreaterThanOrEqualTo(String value) {
            addCriterion("advert_url >=", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlLessThan(String value) {
            addCriterion("advert_url <", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlLessThanOrEqualTo(String value) {
            addCriterion("advert_url <=", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlLike(String value) {
            addCriterion("advert_url like", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlNotLike(String value) {
            addCriterion("advert_url not like", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlIn(List<String> values) {
            addCriterion("advert_url in", values, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlNotIn(List<String> values) {
            addCriterion("advert_url not in", values, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlBetween(String value1, String value2) {
            addCriterion("advert_url between", value1, value2, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlNotBetween(String value1, String value2) {
            addCriterion("advert_url not between", value1, value2, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertImgIsNull() {
            addCriterion("advert_img is null");
            return (Criteria) this;
        }

        public Criteria andAdvertImgIsNotNull() {
            addCriterion("advert_img is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertImgEqualTo(String value) {
            addCriterion("advert_img =", value, "advertImg");
            return (Criteria) this;
        }

        public Criteria andAdvertImgNotEqualTo(String value) {
            addCriterion("advert_img <>", value, "advertImg");
            return (Criteria) this;
        }

        public Criteria andAdvertImgGreaterThan(String value) {
            addCriterion("advert_img >", value, "advertImg");
            return (Criteria) this;
        }

        public Criteria andAdvertImgGreaterThanOrEqualTo(String value) {
            addCriterion("advert_img >=", value, "advertImg");
            return (Criteria) this;
        }

        public Criteria andAdvertImgLessThan(String value) {
            addCriterion("advert_img <", value, "advertImg");
            return (Criteria) this;
        }

        public Criteria andAdvertImgLessThanOrEqualTo(String value) {
            addCriterion("advert_img <=", value, "advertImg");
            return (Criteria) this;
        }

        public Criteria andAdvertImgLike(String value) {
            addCriterion("advert_img like", value, "advertImg");
            return (Criteria) this;
        }

        public Criteria andAdvertImgNotLike(String value) {
            addCriterion("advert_img not like", value, "advertImg");
            return (Criteria) this;
        }

        public Criteria andAdvertImgIn(List<String> values) {
            addCriterion("advert_img in", values, "advertImg");
            return (Criteria) this;
        }

        public Criteria andAdvertImgNotIn(List<String> values) {
            addCriterion("advert_img not in", values, "advertImg");
            return (Criteria) this;
        }

        public Criteria andAdvertImgBetween(String value1, String value2) {
            addCriterion("advert_img between", value1, value2, "advertImg");
            return (Criteria) this;
        }

        public Criteria andAdvertImgNotBetween(String value1, String value2) {
            addCriterion("advert_img not between", value1, value2, "advertImg");
            return (Criteria) this;
        }

        public Criteria andAdvertTypeIsNull() {
            addCriterion("advert_type is null");
            return (Criteria) this;
        }

        public Criteria andAdvertTypeIsNotNull() {
            addCriterion("advert_type is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertTypeEqualTo(Integer value) {
            addCriterion("advert_type =", value, "advertType");
            return (Criteria) this;
        }

        public Criteria andAdvertTypeNotEqualTo(Integer value) {
            addCriterion("advert_type <>", value, "advertType");
            return (Criteria) this;
        }

        public Criteria andAdvertTypeGreaterThan(Integer value) {
            addCriterion("advert_type >", value, "advertType");
            return (Criteria) this;
        }

        public Criteria andAdvertTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("advert_type >=", value, "advertType");
            return (Criteria) this;
        }

        public Criteria andAdvertTypeLessThan(Integer value) {
            addCriterion("advert_type <", value, "advertType");
            return (Criteria) this;
        }

        public Criteria andAdvertTypeLessThanOrEqualTo(Integer value) {
            addCriterion("advert_type <=", value, "advertType");
            return (Criteria) this;
        }

        public Criteria andAdvertTypeIn(List<Integer> values) {
            addCriterion("advert_type in", values, "advertType");
            return (Criteria) this;
        }

        public Criteria andAdvertTypeNotIn(List<Integer> values) {
            addCriterion("advert_type not in", values, "advertType");
            return (Criteria) this;
        }

        public Criteria andAdvertTypeBetween(Integer value1, Integer value2) {
            addCriterion("advert_type between", value1, value2, "advertType");
            return (Criteria) this;
        }

        public Criteria andAdvertTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("advert_type not between", value1, value2, "advertType");
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