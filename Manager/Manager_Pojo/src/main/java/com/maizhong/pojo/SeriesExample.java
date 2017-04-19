package com.maizhong.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeriesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SeriesExample() {
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

        public Criteria andSeriesIdIsNull() {
            addCriterion("series_id is null");
            return (Criteria) this;
        }

        public Criteria andSeriesIdIsNotNull() {
            addCriterion("series_id is not null");
            return (Criteria) this;
        }

        public Criteria andSeriesIdEqualTo(Integer value) {
            addCriterion("series_id =", value, "seriesId");
            return (Criteria) this;
        }

        public Criteria andSeriesIdNotEqualTo(Integer value) {
            addCriterion("series_id <>", value, "seriesId");
            return (Criteria) this;
        }

        public Criteria andSeriesIdGreaterThan(Integer value) {
            addCriterion("series_id >", value, "seriesId");
            return (Criteria) this;
        }

        public Criteria andSeriesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("series_id >=", value, "seriesId");
            return (Criteria) this;
        }

        public Criteria andSeriesIdLessThan(Integer value) {
            addCriterion("series_id <", value, "seriesId");
            return (Criteria) this;
        }

        public Criteria andSeriesIdLessThanOrEqualTo(Integer value) {
            addCriterion("series_id <=", value, "seriesId");
            return (Criteria) this;
        }

        public Criteria andSeriesIdIn(List<Integer> values) {
            addCriterion("series_id in", values, "seriesId");
            return (Criteria) this;
        }

        public Criteria andSeriesIdNotIn(List<Integer> values) {
            addCriterion("series_id not in", values, "seriesId");
            return (Criteria) this;
        }

        public Criteria andSeriesIdBetween(Integer value1, Integer value2) {
            addCriterion("series_id between", value1, value2, "seriesId");
            return (Criteria) this;
        }

        public Criteria andSeriesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("series_id not between", value1, value2, "seriesId");
            return (Criteria) this;
        }

        public Criteria andSeriesNameIsNull() {
            addCriterion("series_name is null");
            return (Criteria) this;
        }

        public Criteria andSeriesNameIsNotNull() {
            addCriterion("series_name is not null");
            return (Criteria) this;
        }

        public Criteria andSeriesNameEqualTo(String value) {
            addCriterion("series_name =", value, "seriesName");
            return (Criteria) this;
        }

        public Criteria andSeriesNameNotEqualTo(String value) {
            addCriterion("series_name <>", value, "seriesName");
            return (Criteria) this;
        }

        public Criteria andSeriesNameGreaterThan(String value) {
            addCriterion("series_name >", value, "seriesName");
            return (Criteria) this;
        }

        public Criteria andSeriesNameGreaterThanOrEqualTo(String value) {
            addCriterion("series_name >=", value, "seriesName");
            return (Criteria) this;
        }

        public Criteria andSeriesNameLessThan(String value) {
            addCriterion("series_name <", value, "seriesName");
            return (Criteria) this;
        }

        public Criteria andSeriesNameLessThanOrEqualTo(String value) {
            addCriterion("series_name <=", value, "seriesName");
            return (Criteria) this;
        }

        public Criteria andSeriesNameLike(String value) {
            addCriterion("series_name like", value, "seriesName");
            return (Criteria) this;
        }

        public Criteria andSeriesNameNotLike(String value) {
            addCriterion("series_name not like", value, "seriesName");
            return (Criteria) this;
        }

        public Criteria andSeriesNameIn(List<String> values) {
            addCriterion("series_name in", values, "seriesName");
            return (Criteria) this;
        }

        public Criteria andSeriesNameNotIn(List<String> values) {
            addCriterion("series_name not in", values, "seriesName");
            return (Criteria) this;
        }

        public Criteria andSeriesNameBetween(String value1, String value2) {
            addCriterion("series_name between", value1, value2, "seriesName");
            return (Criteria) this;
        }

        public Criteria andSeriesNameNotBetween(String value1, String value2) {
            addCriterion("series_name not between", value1, value2, "seriesName");
            return (Criteria) this;
        }

        public Criteria andSeriesGroupNameIsNull() {
            addCriterion("series_group_name is null");
            return (Criteria) this;
        }

        public Criteria andSeriesGroupNameIsNotNull() {
            addCriterion("series_group_name is not null");
            return (Criteria) this;
        }

        public Criteria andSeriesGroupNameEqualTo(String value) {
            addCriterion("series_group_name =", value, "seriesGroupName");
            return (Criteria) this;
        }

        public Criteria andSeriesGroupNameNotEqualTo(String value) {
            addCriterion("series_group_name <>", value, "seriesGroupName");
            return (Criteria) this;
        }

        public Criteria andSeriesGroupNameGreaterThan(String value) {
            addCriterion("series_group_name >", value, "seriesGroupName");
            return (Criteria) this;
        }

        public Criteria andSeriesGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("series_group_name >=", value, "seriesGroupName");
            return (Criteria) this;
        }

        public Criteria andSeriesGroupNameLessThan(String value) {
            addCriterion("series_group_name <", value, "seriesGroupName");
            return (Criteria) this;
        }

        public Criteria andSeriesGroupNameLessThanOrEqualTo(String value) {
            addCriterion("series_group_name <=", value, "seriesGroupName");
            return (Criteria) this;
        }

        public Criteria andSeriesGroupNameLike(String value) {
            addCriterion("series_group_name like", value, "seriesGroupName");
            return (Criteria) this;
        }

        public Criteria andSeriesGroupNameNotLike(String value) {
            addCriterion("series_group_name not like", value, "seriesGroupName");
            return (Criteria) this;
        }

        public Criteria andSeriesGroupNameIn(List<String> values) {
            addCriterion("series_group_name in", values, "seriesGroupName");
            return (Criteria) this;
        }

        public Criteria andSeriesGroupNameNotIn(List<String> values) {
            addCriterion("series_group_name not in", values, "seriesGroupName");
            return (Criteria) this;
        }

        public Criteria andSeriesGroupNameBetween(String value1, String value2) {
            addCriterion("series_group_name between", value1, value2, "seriesGroupName");
            return (Criteria) this;
        }

        public Criteria andSeriesGroupNameNotBetween(String value1, String value2) {
            addCriterion("series_group_name not between", value1, value2, "seriesGroupName");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Integer value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Integer value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Integer value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Integer value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Integer value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Integer> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Integer> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Integer value1, Integer value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Integer value1, Integer value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
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