package com.maizhong.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbCarPropExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbCarPropExample() {
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

        public Criteria andUnableIsNull() {
            addCriterion("unable is null");
            return (Criteria) this;
        }

        public Criteria andUnableIsNotNull() {
            addCriterion("unable is not null");
            return (Criteria) this;
        }

        public Criteria andUnableEqualTo(Integer value) {
            addCriterion("unable =", value, "unable");
            return (Criteria) this;
        }

        public Criteria andUnableNotEqualTo(Integer value) {
            addCriterion("unable <>", value, "unable");
            return (Criteria) this;
        }

        public Criteria andUnableGreaterThan(Integer value) {
            addCriterion("unable >", value, "unable");
            return (Criteria) this;
        }

        public Criteria andUnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("unable >=", value, "unable");
            return (Criteria) this;
        }

        public Criteria andUnableLessThan(Integer value) {
            addCriterion("unable <", value, "unable");
            return (Criteria) this;
        }

        public Criteria andUnableLessThanOrEqualTo(Integer value) {
            addCriterion("unable <=", value, "unable");
            return (Criteria) this;
        }

        public Criteria andUnableIn(List<Integer> values) {
            addCriterion("unable in", values, "unable");
            return (Criteria) this;
        }

        public Criteria andUnableNotIn(List<Integer> values) {
            addCriterion("unable not in", values, "unable");
            return (Criteria) this;
        }

        public Criteria andUnableBetween(Integer value1, Integer value2) {
            addCriterion("unable between", value1, value2, "unable");
            return (Criteria) this;
        }

        public Criteria andUnableNotBetween(Integer value1, Integer value2) {
            addCriterion("unable not between", value1, value2, "unable");
            return (Criteria) this;
        }

        public Criteria andManufacturersIsNull() {
            addCriterion("manufacturers is null");
            return (Criteria) this;
        }

        public Criteria andManufacturersIsNotNull() {
            addCriterion("manufacturers is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturersEqualTo(String value) {
            addCriterion("manufacturers =", value, "manufacturers");
            return (Criteria) this;
        }

        public Criteria andManufacturersNotEqualTo(String value) {
            addCriterion("manufacturers <>", value, "manufacturers");
            return (Criteria) this;
        }

        public Criteria andManufacturersGreaterThan(String value) {
            addCriterion("manufacturers >", value, "manufacturers");
            return (Criteria) this;
        }

        public Criteria andManufacturersGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturers >=", value, "manufacturers");
            return (Criteria) this;
        }

        public Criteria andManufacturersLessThan(String value) {
            addCriterion("manufacturers <", value, "manufacturers");
            return (Criteria) this;
        }

        public Criteria andManufacturersLessThanOrEqualTo(String value) {
            addCriterion("manufacturers <=", value, "manufacturers");
            return (Criteria) this;
        }

        public Criteria andManufacturersLike(String value) {
            addCriterion("manufacturers like", value, "manufacturers");
            return (Criteria) this;
        }

        public Criteria andManufacturersNotLike(String value) {
            addCriterion("manufacturers not like", value, "manufacturers");
            return (Criteria) this;
        }

        public Criteria andManufacturersIn(List<String> values) {
            addCriterion("manufacturers in", values, "manufacturers");
            return (Criteria) this;
        }

        public Criteria andManufacturersNotIn(List<String> values) {
            addCriterion("manufacturers not in", values, "manufacturers");
            return (Criteria) this;
        }

        public Criteria andManufacturersBetween(String value1, String value2) {
            addCriterion("manufacturers between", value1, value2, "manufacturers");
            return (Criteria) this;
        }

        public Criteria andManufacturersNotBetween(String value1, String value2) {
            addCriterion("manufacturers not between", value1, value2, "manufacturers");
            return (Criteria) this;
        }

        public Criteria andConstructionIsNull() {
            addCriterion("construction is null");
            return (Criteria) this;
        }

        public Criteria andConstructionIsNotNull() {
            addCriterion("construction is not null");
            return (Criteria) this;
        }

        public Criteria andConstructionEqualTo(String value) {
            addCriterion("construction =", value, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionNotEqualTo(String value) {
            addCriterion("construction <>", value, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionGreaterThan(String value) {
            addCriterion("construction >", value, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionGreaterThanOrEqualTo(String value) {
            addCriterion("construction >=", value, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionLessThan(String value) {
            addCriterion("construction <", value, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionLessThanOrEqualTo(String value) {
            addCriterion("construction <=", value, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionLike(String value) {
            addCriterion("construction like", value, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionNotLike(String value) {
            addCriterion("construction not like", value, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionIn(List<String> values) {
            addCriterion("construction in", values, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionNotIn(List<String> values) {
            addCriterion("construction not in", values, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionBetween(String value1, String value2) {
            addCriterion("construction between", value1, value2, "construction");
            return (Criteria) this;
        }

        public Criteria andConstructionNotBetween(String value1, String value2) {
            addCriterion("construction not between", value1, value2, "construction");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(String value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(String value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(String value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(String value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(String value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(String value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLike(String value) {
            addCriterion("size like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotLike(String value) {
            addCriterion("size not like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<String> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<String> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(String value1, String value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(String value1, String value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andAxleDistanceIsNull() {
            addCriterion("axle_distance is null");
            return (Criteria) this;
        }

        public Criteria andAxleDistanceIsNotNull() {
            addCriterion("axle_distance is not null");
            return (Criteria) this;
        }

        public Criteria andAxleDistanceEqualTo(Double value) {
            addCriterion("axle_distance =", value, "axleDistance");
            return (Criteria) this;
        }

        public Criteria andAxleDistanceNotEqualTo(Double value) {
            addCriterion("axle_distance <>", value, "axleDistance");
            return (Criteria) this;
        }

        public Criteria andAxleDistanceGreaterThan(Double value) {
            addCriterion("axle_distance >", value, "axleDistance");
            return (Criteria) this;
        }

        public Criteria andAxleDistanceGreaterThanOrEqualTo(Double value) {
            addCriterion("axle_distance >=", value, "axleDistance");
            return (Criteria) this;
        }

        public Criteria andAxleDistanceLessThan(Double value) {
            addCriterion("axle_distance <", value, "axleDistance");
            return (Criteria) this;
        }

        public Criteria andAxleDistanceLessThanOrEqualTo(Double value) {
            addCriterion("axle_distance <=", value, "axleDistance");
            return (Criteria) this;
        }

        public Criteria andAxleDistanceIn(List<Double> values) {
            addCriterion("axle_distance in", values, "axleDistance");
            return (Criteria) this;
        }

        public Criteria andAxleDistanceNotIn(List<Double> values) {
            addCriterion("axle_distance not in", values, "axleDistance");
            return (Criteria) this;
        }

        public Criteria andAxleDistanceBetween(Double value1, Double value2) {
            addCriterion("axle_distance between", value1, value2, "axleDistance");
            return (Criteria) this;
        }

        public Criteria andAxleDistanceNotBetween(Double value1, Double value2) {
            addCriterion("axle_distance not between", value1, value2, "axleDistance");
            return (Criteria) this;
        }

        public Criteria andEngineIsNull() {
            addCriterion("engine is null");
            return (Criteria) this;
        }

        public Criteria andEngineIsNotNull() {
            addCriterion("engine is not null");
            return (Criteria) this;
        }

        public Criteria andEngineEqualTo(String value) {
            addCriterion("engine =", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineNotEqualTo(String value) {
            addCriterion("engine <>", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineGreaterThan(String value) {
            addCriterion("engine >", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineGreaterThanOrEqualTo(String value) {
            addCriterion("engine >=", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineLessThan(String value) {
            addCriterion("engine <", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineLessThanOrEqualTo(String value) {
            addCriterion("engine <=", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineLike(String value) {
            addCriterion("engine like", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineNotLike(String value) {
            addCriterion("engine not like", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineIn(List<String> values) {
            addCriterion("engine in", values, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineNotIn(List<String> values) {
            addCriterion("engine not in", values, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineBetween(String value1, String value2) {
            addCriterion("engine between", value1, value2, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineNotBetween(String value1, String value2) {
            addCriterion("engine not between", value1, value2, "engine");
            return (Criteria) this;
        }

        public Criteria andOilNumIsNull() {
            addCriterion("oil_num is null");
            return (Criteria) this;
        }

        public Criteria andOilNumIsNotNull() {
            addCriterion("oil_num is not null");
            return (Criteria) this;
        }

        public Criteria andOilNumEqualTo(String value) {
            addCriterion("oil_num =", value, "oilNum");
            return (Criteria) this;
        }

        public Criteria andOilNumNotEqualTo(String value) {
            addCriterion("oil_num <>", value, "oilNum");
            return (Criteria) this;
        }

        public Criteria andOilNumGreaterThan(String value) {
            addCriterion("oil_num >", value, "oilNum");
            return (Criteria) this;
        }

        public Criteria andOilNumGreaterThanOrEqualTo(String value) {
            addCriterion("oil_num >=", value, "oilNum");
            return (Criteria) this;
        }

        public Criteria andOilNumLessThan(String value) {
            addCriterion("oil_num <", value, "oilNum");
            return (Criteria) this;
        }

        public Criteria andOilNumLessThanOrEqualTo(String value) {
            addCriterion("oil_num <=", value, "oilNum");
            return (Criteria) this;
        }

        public Criteria andOilNumLike(String value) {
            addCriterion("oil_num like", value, "oilNum");
            return (Criteria) this;
        }

        public Criteria andOilNumNotLike(String value) {
            addCriterion("oil_num not like", value, "oilNum");
            return (Criteria) this;
        }

        public Criteria andOilNumIn(List<String> values) {
            addCriterion("oil_num in", values, "oilNum");
            return (Criteria) this;
        }

        public Criteria andOilNumNotIn(List<String> values) {
            addCriterion("oil_num not in", values, "oilNum");
            return (Criteria) this;
        }

        public Criteria andOilNumBetween(String value1, String value2) {
            addCriterion("oil_num between", value1, value2, "oilNum");
            return (Criteria) this;
        }

        public Criteria andOilNumNotBetween(String value1, String value2) {
            addCriterion("oil_num not between", value1, value2, "oilNum");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNull() {
            addCriterion("capacity is null");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNotNull() {
            addCriterion("capacity is not null");
            return (Criteria) this;
        }

        public Criteria andCapacityEqualTo(String value) {
            addCriterion("capacity =", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotEqualTo(String value) {
            addCriterion("capacity <>", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThan(String value) {
            addCriterion("capacity >", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThanOrEqualTo(String value) {
            addCriterion("capacity >=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThan(String value) {
            addCriterion("capacity <", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThanOrEqualTo(String value) {
            addCriterion("capacity <=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLike(String value) {
            addCriterion("capacity like", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotLike(String value) {
            addCriterion("capacity not like", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityIn(List<String> values) {
            addCriterion("capacity in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotIn(List<String> values) {
            addCriterion("capacity not in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityBetween(String value1, String value2) {
            addCriterion("capacity between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotBetween(String value1, String value2) {
            addCriterion("capacity not between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andOilCostIsNull() {
            addCriterion("oil_cost is null");
            return (Criteria) this;
        }

        public Criteria andOilCostIsNotNull() {
            addCriterion("oil_cost is not null");
            return (Criteria) this;
        }

        public Criteria andOilCostEqualTo(String value) {
            addCriterion("oil_cost =", value, "oilCost");
            return (Criteria) this;
        }

        public Criteria andOilCostNotEqualTo(String value) {
            addCriterion("oil_cost <>", value, "oilCost");
            return (Criteria) this;
        }

        public Criteria andOilCostGreaterThan(String value) {
            addCriterion("oil_cost >", value, "oilCost");
            return (Criteria) this;
        }

        public Criteria andOilCostGreaterThanOrEqualTo(String value) {
            addCriterion("oil_cost >=", value, "oilCost");
            return (Criteria) this;
        }

        public Criteria andOilCostLessThan(String value) {
            addCriterion("oil_cost <", value, "oilCost");
            return (Criteria) this;
        }

        public Criteria andOilCostLessThanOrEqualTo(String value) {
            addCriterion("oil_cost <=", value, "oilCost");
            return (Criteria) this;
        }

        public Criteria andOilCostLike(String value) {
            addCriterion("oil_cost like", value, "oilCost");
            return (Criteria) this;
        }

        public Criteria andOilCostNotLike(String value) {
            addCriterion("oil_cost not like", value, "oilCost");
            return (Criteria) this;
        }

        public Criteria andOilCostIn(List<String> values) {
            addCriterion("oil_cost in", values, "oilCost");
            return (Criteria) this;
        }

        public Criteria andOilCostNotIn(List<String> values) {
            addCriterion("oil_cost not in", values, "oilCost");
            return (Criteria) this;
        }

        public Criteria andOilCostBetween(String value1, String value2) {
            addCriterion("oil_cost between", value1, value2, "oilCost");
            return (Criteria) this;
        }

        public Criteria andOilCostNotBetween(String value1, String value2) {
            addCriterion("oil_cost not between", value1, value2, "oilCost");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNormIsNull() {
            addCriterion("environment_norm is null");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNormIsNotNull() {
            addCriterion("environment_norm is not null");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNormEqualTo(String value) {
            addCriterion("environment_norm =", value, "environmentNorm");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNormNotEqualTo(String value) {
            addCriterion("environment_norm <>", value, "environmentNorm");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNormGreaterThan(String value) {
            addCriterion("environment_norm >", value, "environmentNorm");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNormGreaterThanOrEqualTo(String value) {
            addCriterion("environment_norm >=", value, "environmentNorm");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNormLessThan(String value) {
            addCriterion("environment_norm <", value, "environmentNorm");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNormLessThanOrEqualTo(String value) {
            addCriterion("environment_norm <=", value, "environmentNorm");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNormLike(String value) {
            addCriterion("environment_norm like", value, "environmentNorm");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNormNotLike(String value) {
            addCriterion("environment_norm not like", value, "environmentNorm");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNormIn(List<String> values) {
            addCriterion("environment_norm in", values, "environmentNorm");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNormNotIn(List<String> values) {
            addCriterion("environment_norm not in", values, "environmentNorm");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNormBetween(String value1, String value2) {
            addCriterion("environment_norm between", value1, value2, "environmentNorm");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNormNotBetween(String value1, String value2) {
            addCriterion("environment_norm not between", value1, value2, "environmentNorm");
            return (Criteria) this;
        }

        public Criteria andSpeed100IsNull() {
            addCriterion("speed_100 is null");
            return (Criteria) this;
        }

        public Criteria andSpeed100IsNotNull() {
            addCriterion("speed_100 is not null");
            return (Criteria) this;
        }

        public Criteria andSpeed100EqualTo(String value) {
            addCriterion("speed_100 =", value, "speed100");
            return (Criteria) this;
        }

        public Criteria andSpeed100NotEqualTo(String value) {
            addCriterion("speed_100 <>", value, "speed100");
            return (Criteria) this;
        }

        public Criteria andSpeed100GreaterThan(String value) {
            addCriterion("speed_100 >", value, "speed100");
            return (Criteria) this;
        }

        public Criteria andSpeed100GreaterThanOrEqualTo(String value) {
            addCriterion("speed_100 >=", value, "speed100");
            return (Criteria) this;
        }

        public Criteria andSpeed100LessThan(String value) {
            addCriterion("speed_100 <", value, "speed100");
            return (Criteria) this;
        }

        public Criteria andSpeed100LessThanOrEqualTo(String value) {
            addCriterion("speed_100 <=", value, "speed100");
            return (Criteria) this;
        }

        public Criteria andSpeed100Like(String value) {
            addCriterion("speed_100 like", value, "speed100");
            return (Criteria) this;
        }

        public Criteria andSpeed100NotLike(String value) {
            addCriterion("speed_100 not like", value, "speed100");
            return (Criteria) this;
        }

        public Criteria andSpeed100In(List<String> values) {
            addCriterion("speed_100 in", values, "speed100");
            return (Criteria) this;
        }

        public Criteria andSpeed100NotIn(List<String> values) {
            addCriterion("speed_100 not in", values, "speed100");
            return (Criteria) this;
        }

        public Criteria andSpeed100Between(String value1, String value2) {
            addCriterion("speed_100 between", value1, value2, "speed100");
            return (Criteria) this;
        }

        public Criteria andSpeed100NotBetween(String value1, String value2) {
            addCriterion("speed_100 not between", value1, value2, "speed100");
            return (Criteria) this;
        }

        public Criteria andProtectLimitIsNull() {
            addCriterion("protect_limit is null");
            return (Criteria) this;
        }

        public Criteria andProtectLimitIsNotNull() {
            addCriterion("protect_limit is not null");
            return (Criteria) this;
        }

        public Criteria andProtectLimitEqualTo(String value) {
            addCriterion("protect_limit =", value, "protectLimit");
            return (Criteria) this;
        }

        public Criteria andProtectLimitNotEqualTo(String value) {
            addCriterion("protect_limit <>", value, "protectLimit");
            return (Criteria) this;
        }

        public Criteria andProtectLimitGreaterThan(String value) {
            addCriterion("protect_limit >", value, "protectLimit");
            return (Criteria) this;
        }

        public Criteria andProtectLimitGreaterThanOrEqualTo(String value) {
            addCriterion("protect_limit >=", value, "protectLimit");
            return (Criteria) this;
        }

        public Criteria andProtectLimitLessThan(String value) {
            addCriterion("protect_limit <", value, "protectLimit");
            return (Criteria) this;
        }

        public Criteria andProtectLimitLessThanOrEqualTo(String value) {
            addCriterion("protect_limit <=", value, "protectLimit");
            return (Criteria) this;
        }

        public Criteria andProtectLimitLike(String value) {
            addCriterion("protect_limit like", value, "protectLimit");
            return (Criteria) this;
        }

        public Criteria andProtectLimitNotLike(String value) {
            addCriterion("protect_limit not like", value, "protectLimit");
            return (Criteria) this;
        }

        public Criteria andProtectLimitIn(List<String> values) {
            addCriterion("protect_limit in", values, "protectLimit");
            return (Criteria) this;
        }

        public Criteria andProtectLimitNotIn(List<String> values) {
            addCriterion("protect_limit not in", values, "protectLimit");
            return (Criteria) this;
        }

        public Criteria andProtectLimitBetween(String value1, String value2) {
            addCriterion("protect_limit between", value1, value2, "protectLimit");
            return (Criteria) this;
        }

        public Criteria andProtectLimitNotBetween(String value1, String value2) {
            addCriterion("protect_limit not between", value1, value2, "protectLimit");
            return (Criteria) this;
        }

        public Criteria andSpeedHighIsNull() {
            addCriterion("speed_high is null");
            return (Criteria) this;
        }

        public Criteria andSpeedHighIsNotNull() {
            addCriterion("speed_high is not null");
            return (Criteria) this;
        }

        public Criteria andSpeedHighEqualTo(Double value) {
            addCriterion("speed_high =", value, "speedHigh");
            return (Criteria) this;
        }

        public Criteria andSpeedHighNotEqualTo(Double value) {
            addCriterion("speed_high <>", value, "speedHigh");
            return (Criteria) this;
        }

        public Criteria andSpeedHighGreaterThan(Double value) {
            addCriterion("speed_high >", value, "speedHigh");
            return (Criteria) this;
        }

        public Criteria andSpeedHighGreaterThanOrEqualTo(Double value) {
            addCriterion("speed_high >=", value, "speedHigh");
            return (Criteria) this;
        }

        public Criteria andSpeedHighLessThan(Double value) {
            addCriterion("speed_high <", value, "speedHigh");
            return (Criteria) this;
        }

        public Criteria andSpeedHighLessThanOrEqualTo(Double value) {
            addCriterion("speed_high <=", value, "speedHigh");
            return (Criteria) this;
        }

        public Criteria andSpeedHighIn(List<Double> values) {
            addCriterion("speed_high in", values, "speedHigh");
            return (Criteria) this;
        }

        public Criteria andSpeedHighNotIn(List<Double> values) {
            addCriterion("speed_high not in", values, "speedHigh");
            return (Criteria) this;
        }

        public Criteria andSpeedHighBetween(Double value1, Double value2) {
            addCriterion("speed_high between", value1, value2, "speedHigh");
            return (Criteria) this;
        }

        public Criteria andSpeedHighNotBetween(Double value1, Double value2) {
            addCriterion("speed_high not between", value1, value2, "speedHigh");
            return (Criteria) this;
        }

        public Criteria andDriveTypeIsNull() {
            addCriterion("drive_type is null");
            return (Criteria) this;
        }

        public Criteria andDriveTypeIsNotNull() {
            addCriterion("drive_type is not null");
            return (Criteria) this;
        }

        public Criteria andDriveTypeEqualTo(String value) {
            addCriterion("drive_type =", value, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeNotEqualTo(String value) {
            addCriterion("drive_type <>", value, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeGreaterThan(String value) {
            addCriterion("drive_type >", value, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeGreaterThanOrEqualTo(String value) {
            addCriterion("drive_type >=", value, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeLessThan(String value) {
            addCriterion("drive_type <", value, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeLessThanOrEqualTo(String value) {
            addCriterion("drive_type <=", value, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeLike(String value) {
            addCriterion("drive_type like", value, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeNotLike(String value) {
            addCriterion("drive_type not like", value, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeIn(List<String> values) {
            addCriterion("drive_type in", values, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeNotIn(List<String> values) {
            addCriterion("drive_type not in", values, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeBetween(String value1, String value2) {
            addCriterion("drive_type between", value1, value2, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeNotBetween(String value1, String value2) {
            addCriterion("drive_type not between", value1, value2, "driveType");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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