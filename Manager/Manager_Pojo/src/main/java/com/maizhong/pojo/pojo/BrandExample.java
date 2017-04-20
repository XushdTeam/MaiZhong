package com.maizhong.pojo.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrandExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BrandExample() {
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

        public Criteria andBrandNameIsNull() {
            addCriterion("brand_name is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("brand_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("brand_name =", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("brand_name <>", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("brand_name >", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name >=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("brand_name <", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("brand_name <=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("brand_name like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("brand_name not like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIn(List<String> values) {
            addCriterion("brand_name in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotIn(List<String> values) {
            addCriterion("brand_name not in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("brand_name between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("brand_name not between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andInitialIsNull() {
            addCriterion("initial is null");
            return (Criteria) this;
        }

        public Criteria andInitialIsNotNull() {
            addCriterion("initial is not null");
            return (Criteria) this;
        }

        public Criteria andInitialEqualTo(String value) {
            addCriterion("initial =", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialNotEqualTo(String value) {
            addCriterion("initial <>", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialGreaterThan(String value) {
            addCriterion("initial >", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialGreaterThanOrEqualTo(String value) {
            addCriterion("initial >=", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialLessThan(String value) {
            addCriterion("initial <", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialLessThanOrEqualTo(String value) {
            addCriterion("initial <=", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialLike(String value) {
            addCriterion("initial like", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialNotLike(String value) {
            addCriterion("initial not like", value, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialIn(List<String> values) {
            addCriterion("initial in", values, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialNotIn(List<String> values) {
            addCriterion("initial not in", values, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialBetween(String value1, String value2) {
            addCriterion("initial between", value1, value2, "initial");
            return (Criteria) this;
        }

        public Criteria andInitialNotBetween(String value1, String value2) {
            addCriterion("initial not between", value1, value2, "initial");
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

        public Criteria andSmallLogoIsNull() {
            addCriterion("small_logo is null");
            return (Criteria) this;
        }

        public Criteria andSmallLogoIsNotNull() {
            addCriterion("small_logo is not null");
            return (Criteria) this;
        }

        public Criteria andSmallLogoEqualTo(String value) {
            addCriterion("small_logo =", value, "smallLogo");
            return (Criteria) this;
        }

        public Criteria andSmallLogoNotEqualTo(String value) {
            addCriterion("small_logo <>", value, "smallLogo");
            return (Criteria) this;
        }

        public Criteria andSmallLogoGreaterThan(String value) {
            addCriterion("small_logo >", value, "smallLogo");
            return (Criteria) this;
        }

        public Criteria andSmallLogoGreaterThanOrEqualTo(String value) {
            addCriterion("small_logo >=", value, "smallLogo");
            return (Criteria) this;
        }

        public Criteria andSmallLogoLessThan(String value) {
            addCriterion("small_logo <", value, "smallLogo");
            return (Criteria) this;
        }

        public Criteria andSmallLogoLessThanOrEqualTo(String value) {
            addCriterion("small_logo <=", value, "smallLogo");
            return (Criteria) this;
        }

        public Criteria andSmallLogoLike(String value) {
            addCriterion("small_logo like", value, "smallLogo");
            return (Criteria) this;
        }

        public Criteria andSmallLogoNotLike(String value) {
            addCriterion("small_logo not like", value, "smallLogo");
            return (Criteria) this;
        }

        public Criteria andSmallLogoIn(List<String> values) {
            addCriterion("small_logo in", values, "smallLogo");
            return (Criteria) this;
        }

        public Criteria andSmallLogoNotIn(List<String> values) {
            addCriterion("small_logo not in", values, "smallLogo");
            return (Criteria) this;
        }

        public Criteria andSmallLogoBetween(String value1, String value2) {
            addCriterion("small_logo between", value1, value2, "smallLogo");
            return (Criteria) this;
        }

        public Criteria andSmallLogoNotBetween(String value1, String value2) {
            addCriterion("small_logo not between", value1, value2, "smallLogo");
            return (Criteria) this;
        }

        public Criteria andLargeLogoIsNull() {
            addCriterion("large_logo is null");
            return (Criteria) this;
        }

        public Criteria andLargeLogoIsNotNull() {
            addCriterion("large_logo is not null");
            return (Criteria) this;
        }

        public Criteria andLargeLogoEqualTo(String value) {
            addCriterion("large_logo =", value, "largeLogo");
            return (Criteria) this;
        }

        public Criteria andLargeLogoNotEqualTo(String value) {
            addCriterion("large_logo <>", value, "largeLogo");
            return (Criteria) this;
        }

        public Criteria andLargeLogoGreaterThan(String value) {
            addCriterion("large_logo >", value, "largeLogo");
            return (Criteria) this;
        }

        public Criteria andLargeLogoGreaterThanOrEqualTo(String value) {
            addCriterion("large_logo >=", value, "largeLogo");
            return (Criteria) this;
        }

        public Criteria andLargeLogoLessThan(String value) {
            addCriterion("large_logo <", value, "largeLogo");
            return (Criteria) this;
        }

        public Criteria andLargeLogoLessThanOrEqualTo(String value) {
            addCriterion("large_logo <=", value, "largeLogo");
            return (Criteria) this;
        }

        public Criteria andLargeLogoLike(String value) {
            addCriterion("large_logo like", value, "largeLogo");
            return (Criteria) this;
        }

        public Criteria andLargeLogoNotLike(String value) {
            addCriterion("large_logo not like", value, "largeLogo");
            return (Criteria) this;
        }

        public Criteria andLargeLogoIn(List<String> values) {
            addCriterion("large_logo in", values, "largeLogo");
            return (Criteria) this;
        }

        public Criteria andLargeLogoNotIn(List<String> values) {
            addCriterion("large_logo not in", values, "largeLogo");
            return (Criteria) this;
        }

        public Criteria andLargeLogoBetween(String value1, String value2) {
            addCriterion("large_logo between", value1, value2, "largeLogo");
            return (Criteria) this;
        }

        public Criteria andLargeLogoNotBetween(String value1, String value2) {
            addCriterion("large_logo not between", value1, value2, "largeLogo");
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