package com.maizhong.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModelExample() {
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

        public Criteria andModelIdIsNull() {
            addCriterion("model_id is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("model_id is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(Integer value) {
            addCriterion("model_id =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(Integer value) {
            addCriterion("model_id <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(Integer value) {
            addCriterion("model_id >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("model_id >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(Integer value) {
            addCriterion("model_id <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(Integer value) {
            addCriterion("model_id <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<Integer> values) {
            addCriterion("model_id in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<Integer> values) {
            addCriterion("model_id not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(Integer value1, Integer value2) {
            addCriterion("model_id between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(Integer value1, Integer value2) {
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

        public Criteria andModelPriceIsNull() {
            addCriterion("model_price is null");
            return (Criteria) this;
        }

        public Criteria andModelPriceIsNotNull() {
            addCriterion("model_price is not null");
            return (Criteria) this;
        }

        public Criteria andModelPriceEqualTo(BigDecimal value) {
            addCriterion("model_price =", value, "modelPrice");
            return (Criteria) this;
        }

        public Criteria andModelPriceNotEqualTo(BigDecimal value) {
            addCriterion("model_price <>", value, "modelPrice");
            return (Criteria) this;
        }

        public Criteria andModelPriceGreaterThan(BigDecimal value) {
            addCriterion("model_price >", value, "modelPrice");
            return (Criteria) this;
        }

        public Criteria andModelPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("model_price >=", value, "modelPrice");
            return (Criteria) this;
        }

        public Criteria andModelPriceLessThan(BigDecimal value) {
            addCriterion("model_price <", value, "modelPrice");
            return (Criteria) this;
        }

        public Criteria andModelPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("model_price <=", value, "modelPrice");
            return (Criteria) this;
        }

        public Criteria andModelPriceIn(List<BigDecimal> values) {
            addCriterion("model_price in", values, "modelPrice");
            return (Criteria) this;
        }

        public Criteria andModelPriceNotIn(List<BigDecimal> values) {
            addCriterion("model_price not in", values, "modelPrice");
            return (Criteria) this;
        }

        public Criteria andModelPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("model_price between", value1, value2, "modelPrice");
            return (Criteria) this;
        }

        public Criteria andModelPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("model_price not between", value1, value2, "modelPrice");
            return (Criteria) this;
        }

        public Criteria andModelYearIsNull() {
            addCriterion("model_year is null");
            return (Criteria) this;
        }

        public Criteria andModelYearIsNotNull() {
            addCriterion("model_year is not null");
            return (Criteria) this;
        }

        public Criteria andModelYearEqualTo(Integer value) {
            addCriterion("model_year =", value, "modelYear");
            return (Criteria) this;
        }

        public Criteria andModelYearNotEqualTo(Integer value) {
            addCriterion("model_year <>", value, "modelYear");
            return (Criteria) this;
        }

        public Criteria andModelYearGreaterThan(Integer value) {
            addCriterion("model_year >", value, "modelYear");
            return (Criteria) this;
        }

        public Criteria andModelYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("model_year >=", value, "modelYear");
            return (Criteria) this;
        }

        public Criteria andModelYearLessThan(Integer value) {
            addCriterion("model_year <", value, "modelYear");
            return (Criteria) this;
        }

        public Criteria andModelYearLessThanOrEqualTo(Integer value) {
            addCriterion("model_year <=", value, "modelYear");
            return (Criteria) this;
        }

        public Criteria andModelYearIn(List<Integer> values) {
            addCriterion("model_year in", values, "modelYear");
            return (Criteria) this;
        }

        public Criteria andModelYearNotIn(List<Integer> values) {
            addCriterion("model_year not in", values, "modelYear");
            return (Criteria) this;
        }

        public Criteria andModelYearBetween(Integer value1, Integer value2) {
            addCriterion("model_year between", value1, value2, "modelYear");
            return (Criteria) this;
        }

        public Criteria andModelYearNotBetween(Integer value1, Integer value2) {
            addCriterion("model_year not between", value1, value2, "modelYear");
            return (Criteria) this;
        }

        public Criteria andMinRegYearIsNull() {
            addCriterion("min_reg_year is null");
            return (Criteria) this;
        }

        public Criteria andMinRegYearIsNotNull() {
            addCriterion("min_reg_year is not null");
            return (Criteria) this;
        }

        public Criteria andMinRegYearEqualTo(Integer value) {
            addCriterion("min_reg_year =", value, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMinRegYearNotEqualTo(Integer value) {
            addCriterion("min_reg_year <>", value, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMinRegYearGreaterThan(Integer value) {
            addCriterion("min_reg_year >", value, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMinRegYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_reg_year >=", value, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMinRegYearLessThan(Integer value) {
            addCriterion("min_reg_year <", value, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMinRegYearLessThanOrEqualTo(Integer value) {
            addCriterion("min_reg_year <=", value, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMinRegYearIn(List<Integer> values) {
            addCriterion("min_reg_year in", values, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMinRegYearNotIn(List<Integer> values) {
            addCriterion("min_reg_year not in", values, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMinRegYearBetween(Integer value1, Integer value2) {
            addCriterion("min_reg_year between", value1, value2, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMinRegYearNotBetween(Integer value1, Integer value2) {
            addCriterion("min_reg_year not between", value1, value2, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearIsNull() {
            addCriterion("max_reg_year is null");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearIsNotNull() {
            addCriterion("max_reg_year is not null");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearEqualTo(Integer value) {
            addCriterion("max_reg_year =", value, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearNotEqualTo(Integer value) {
            addCriterion("max_reg_year <>", value, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearGreaterThan(Integer value) {
            addCriterion("max_reg_year >", value, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_reg_year >=", value, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearLessThan(Integer value) {
            addCriterion("max_reg_year <", value, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearLessThanOrEqualTo(Integer value) {
            addCriterion("max_reg_year <=", value, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearIn(List<Integer> values) {
            addCriterion("max_reg_year in", values, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearNotIn(List<Integer> values) {
            addCriterion("max_reg_year not in", values, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearBetween(Integer value1, Integer value2) {
            addCriterion("max_reg_year between", value1, value2, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearNotBetween(Integer value1, Integer value2) {
            addCriterion("max_reg_year not between", value1, value2, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andLiterIsNull() {
            addCriterion("liter is null");
            return (Criteria) this;
        }

        public Criteria andLiterIsNotNull() {
            addCriterion("liter is not null");
            return (Criteria) this;
        }

        public Criteria andLiterEqualTo(String value) {
            addCriterion("liter =", value, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterNotEqualTo(String value) {
            addCriterion("liter <>", value, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterGreaterThan(String value) {
            addCriterion("liter >", value, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterGreaterThanOrEqualTo(String value) {
            addCriterion("liter >=", value, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterLessThan(String value) {
            addCriterion("liter <", value, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterLessThanOrEqualTo(String value) {
            addCriterion("liter <=", value, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterLike(String value) {
            addCriterion("liter like", value, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterNotLike(String value) {
            addCriterion("liter not like", value, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterIn(List<String> values) {
            addCriterion("liter in", values, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterNotIn(List<String> values) {
            addCriterion("liter not in", values, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterBetween(String value1, String value2) {
            addCriterion("liter between", value1, value2, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterNotBetween(String value1, String value2) {
            addCriterion("liter not between", value1, value2, "liter");
            return (Criteria) this;
        }

        public Criteria andGearTypeIsNull() {
            addCriterion("gear_type is null");
            return (Criteria) this;
        }

        public Criteria andGearTypeIsNotNull() {
            addCriterion("gear_type is not null");
            return (Criteria) this;
        }

        public Criteria andGearTypeEqualTo(String value) {
            addCriterion("gear_type =", value, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeNotEqualTo(String value) {
            addCriterion("gear_type <>", value, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeGreaterThan(String value) {
            addCriterion("gear_type >", value, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeGreaterThanOrEqualTo(String value) {
            addCriterion("gear_type >=", value, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeLessThan(String value) {
            addCriterion("gear_type <", value, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeLessThanOrEqualTo(String value) {
            addCriterion("gear_type <=", value, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeLike(String value) {
            addCriterion("gear_type like", value, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeNotLike(String value) {
            addCriterion("gear_type not like", value, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeIn(List<String> values) {
            addCriterion("gear_type in", values, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeNotIn(List<String> values) {
            addCriterion("gear_type not in", values, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeBetween(String value1, String value2) {
            addCriterion("gear_type between", value1, value2, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeNotBetween(String value1, String value2) {
            addCriterion("gear_type not between", value1, value2, "gearType");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardIsNull() {
            addCriterion("discharge_standard is null");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardIsNotNull() {
            addCriterion("discharge_standard is not null");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardEqualTo(String value) {
            addCriterion("discharge_standard =", value, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardNotEqualTo(String value) {
            addCriterion("discharge_standard <>", value, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardGreaterThan(String value) {
            addCriterion("discharge_standard >", value, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardGreaterThanOrEqualTo(String value) {
            addCriterion("discharge_standard >=", value, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardLessThan(String value) {
            addCriterion("discharge_standard <", value, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardLessThanOrEqualTo(String value) {
            addCriterion("discharge_standard <=", value, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardLike(String value) {
            addCriterion("discharge_standard like", value, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardNotLike(String value) {
            addCriterion("discharge_standard not like", value, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardIn(List<String> values) {
            addCriterion("discharge_standard in", values, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardNotIn(List<String> values) {
            addCriterion("discharge_standard not in", values, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardBetween(String value1, String value2) {
            addCriterion("discharge_standard between", value1, value2, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardNotBetween(String value1, String value2) {
            addCriterion("discharge_standard not between", value1, value2, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andSeatNumberIsNull() {
            addCriterion("seat_number is null");
            return (Criteria) this;
        }

        public Criteria andSeatNumberIsNotNull() {
            addCriterion("seat_number is not null");
            return (Criteria) this;
        }

        public Criteria andSeatNumberEqualTo(String value) {
            addCriterion("seat_number =", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberNotEqualTo(String value) {
            addCriterion("seat_number <>", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberGreaterThan(String value) {
            addCriterion("seat_number >", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberGreaterThanOrEqualTo(String value) {
            addCriterion("seat_number >=", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberLessThan(String value) {
            addCriterion("seat_number <", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberLessThanOrEqualTo(String value) {
            addCriterion("seat_number <=", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberLike(String value) {
            addCriterion("seat_number like", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberNotLike(String value) {
            addCriterion("seat_number not like", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberIn(List<String> values) {
            addCriterion("seat_number in", values, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberNotIn(List<String> values) {
            addCriterion("seat_number not in", values, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberBetween(String value1, String value2) {
            addCriterion("seat_number between", value1, value2, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberNotBetween(String value1, String value2) {
            addCriterion("seat_number not between", value1, value2, "seatNumber");
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

        public Criteria andShortNameIsNull() {
            addCriterion("short_name is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("short_name is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("short_name =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("short_name <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("short_name >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("short_name >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("short_name <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("short_name <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("short_name like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("short_name not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("short_name in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("short_name not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("short_name between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("short_name not between", value1, value2, "shortName");
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