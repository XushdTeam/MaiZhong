package com.maizhong.auction.pojo;

import java.util.ArrayList;
import java.util.List;

public class CkDjzExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CkDjzExample() {
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

        public Criteria andPic1IsNull() {
            addCriterion("pic1 is null");
            return (Criteria) this;
        }

        public Criteria andPic1IsNotNull() {
            addCriterion("pic1 is not null");
            return (Criteria) this;
        }

        public Criteria andPic1EqualTo(String value) {
            addCriterion("pic1 =", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotEqualTo(String value) {
            addCriterion("pic1 <>", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1GreaterThan(String value) {
            addCriterion("pic1 >", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1GreaterThanOrEqualTo(String value) {
            addCriterion("pic1 >=", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1LessThan(String value) {
            addCriterion("pic1 <", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1LessThanOrEqualTo(String value) {
            addCriterion("pic1 <=", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1Like(String value) {
            addCriterion("pic1 like", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotLike(String value) {
            addCriterion("pic1 not like", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1In(List<String> values) {
            addCriterion("pic1 in", values, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotIn(List<String> values) {
            addCriterion("pic1 not in", values, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1Between(String value1, String value2) {
            addCriterion("pic1 between", value1, value2, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotBetween(String value1, String value2) {
            addCriterion("pic1 not between", value1, value2, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic2IsNull() {
            addCriterion("pic2 is null");
            return (Criteria) this;
        }

        public Criteria andPic2IsNotNull() {
            addCriterion("pic2 is not null");
            return (Criteria) this;
        }

        public Criteria andPic2EqualTo(String value) {
            addCriterion("pic2 =", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotEqualTo(String value) {
            addCriterion("pic2 <>", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2GreaterThan(String value) {
            addCriterion("pic2 >", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2GreaterThanOrEqualTo(String value) {
            addCriterion("pic2 >=", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2LessThan(String value) {
            addCriterion("pic2 <", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2LessThanOrEqualTo(String value) {
            addCriterion("pic2 <=", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2Like(String value) {
            addCriterion("pic2 like", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotLike(String value) {
            addCriterion("pic2 not like", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2In(List<String> values) {
            addCriterion("pic2 in", values, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotIn(List<String> values) {
            addCriterion("pic2 not in", values, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2Between(String value1, String value2) {
            addCriterion("pic2 between", value1, value2, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotBetween(String value1, String value2) {
            addCriterion("pic2 not between", value1, value2, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic3IsNull() {
            addCriterion("pic3 is null");
            return (Criteria) this;
        }

        public Criteria andPic3IsNotNull() {
            addCriterion("pic3 is not null");
            return (Criteria) this;
        }

        public Criteria andPic3EqualTo(String value) {
            addCriterion("pic3 =", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3NotEqualTo(String value) {
            addCriterion("pic3 <>", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3GreaterThan(String value) {
            addCriterion("pic3 >", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3GreaterThanOrEqualTo(String value) {
            addCriterion("pic3 >=", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3LessThan(String value) {
            addCriterion("pic3 <", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3LessThanOrEqualTo(String value) {
            addCriterion("pic3 <=", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3Like(String value) {
            addCriterion("pic3 like", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3NotLike(String value) {
            addCriterion("pic3 not like", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3In(List<String> values) {
            addCriterion("pic3 in", values, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3NotIn(List<String> values) {
            addCriterion("pic3 not in", values, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3Between(String value1, String value2) {
            addCriterion("pic3 between", value1, value2, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3NotBetween(String value1, String value2) {
            addCriterion("pic3 not between", value1, value2, "pic3");
            return (Criteria) this;
        }

        public Criteria andWjIsNull() {
            addCriterion("wj is null");
            return (Criteria) this;
        }

        public Criteria andWjIsNotNull() {
            addCriterion("wj is not null");
            return (Criteria) this;
        }

        public Criteria andWjEqualTo(Integer value) {
            addCriterion("wj =", value, "wj");
            return (Criteria) this;
        }

        public Criteria andWjNotEqualTo(Integer value) {
            addCriterion("wj <>", value, "wj");
            return (Criteria) this;
        }

        public Criteria andWjGreaterThan(Integer value) {
            addCriterion("wj >", value, "wj");
            return (Criteria) this;
        }

        public Criteria andWjGreaterThanOrEqualTo(Integer value) {
            addCriterion("wj >=", value, "wj");
            return (Criteria) this;
        }

        public Criteria andWjLessThan(Integer value) {
            addCriterion("wj <", value, "wj");
            return (Criteria) this;
        }

        public Criteria andWjLessThanOrEqualTo(Integer value) {
            addCriterion("wj <=", value, "wj");
            return (Criteria) this;
        }

        public Criteria andWjIn(List<Integer> values) {
            addCriterion("wj in", values, "wj");
            return (Criteria) this;
        }

        public Criteria andWjNotIn(List<Integer> values) {
            addCriterion("wj not in", values, "wj");
            return (Criteria) this;
        }

        public Criteria andWjBetween(Integer value1, Integer value2) {
            addCriterion("wj between", value1, value2, "wj");
            return (Criteria) this;
        }

        public Criteria andWjNotBetween(Integer value1, Integer value2) {
            addCriterion("wj not between", value1, value2, "wj");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(Integer value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(Integer value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(Integer value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(Integer value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(Integer value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(Integer value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<Integer> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<Integer> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(Integer value1, Integer value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(Integer value1, Integer value2) {
            addCriterion("color not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andJkIsNull() {
            addCriterion("jk is null");
            return (Criteria) this;
        }

        public Criteria andJkIsNotNull() {
            addCriterion("jk is not null");
            return (Criteria) this;
        }

        public Criteria andJkEqualTo(Integer value) {
            addCriterion("jk =", value, "jk");
            return (Criteria) this;
        }

        public Criteria andJkNotEqualTo(Integer value) {
            addCriterion("jk <>", value, "jk");
            return (Criteria) this;
        }

        public Criteria andJkGreaterThan(Integer value) {
            addCriterion("jk >", value, "jk");
            return (Criteria) this;
        }

        public Criteria andJkGreaterThanOrEqualTo(Integer value) {
            addCriterion("jk >=", value, "jk");
            return (Criteria) this;
        }

        public Criteria andJkLessThan(Integer value) {
            addCriterion("jk <", value, "jk");
            return (Criteria) this;
        }

        public Criteria andJkLessThanOrEqualTo(Integer value) {
            addCriterion("jk <=", value, "jk");
            return (Criteria) this;
        }

        public Criteria andJkIn(List<Integer> values) {
            addCriterion("jk in", values, "jk");
            return (Criteria) this;
        }

        public Criteria andJkNotIn(List<Integer> values) {
            addCriterion("jk not in", values, "jk");
            return (Criteria) this;
        }

        public Criteria andJkBetween(Integer value1, Integer value2) {
            addCriterion("jk between", value1, value2, "jk");
            return (Criteria) this;
        }

        public Criteria andJkNotBetween(Integer value1, Integer value2) {
            addCriterion("jk not between", value1, value2, "jk");
            return (Criteria) this;
        }

        public Criteria andRszlIsNull() {
            addCriterion("rszl is null");
            return (Criteria) this;
        }

        public Criteria andRszlIsNotNull() {
            addCriterion("rszl is not null");
            return (Criteria) this;
        }

        public Criteria andRszlEqualTo(Integer value) {
            addCriterion("rszl =", value, "rszl");
            return (Criteria) this;
        }

        public Criteria andRszlNotEqualTo(Integer value) {
            addCriterion("rszl <>", value, "rszl");
            return (Criteria) this;
        }

        public Criteria andRszlGreaterThan(Integer value) {
            addCriterion("rszl >", value, "rszl");
            return (Criteria) this;
        }

        public Criteria andRszlGreaterThanOrEqualTo(Integer value) {
            addCriterion("rszl >=", value, "rszl");
            return (Criteria) this;
        }

        public Criteria andRszlLessThan(Integer value) {
            addCriterion("rszl <", value, "rszl");
            return (Criteria) this;
        }

        public Criteria andRszlLessThanOrEqualTo(Integer value) {
            addCriterion("rszl <=", value, "rszl");
            return (Criteria) this;
        }

        public Criteria andRszlIn(List<Integer> values) {
            addCriterion("rszl in", values, "rszl");
            return (Criteria) this;
        }

        public Criteria andRszlNotIn(List<Integer> values) {
            addCriterion("rszl not in", values, "rszl");
            return (Criteria) this;
        }

        public Criteria andRszlBetween(Integer value1, Integer value2) {
            addCriterion("rszl between", value1, value2, "rszl");
            return (Criteria) this;
        }

        public Criteria andRszlNotBetween(Integer value1, Integer value2) {
            addCriterion("rszl not between", value1, value2, "rszl");
            return (Criteria) this;
        }

        public Criteria andPlIsNull() {
            addCriterion("pl is null");
            return (Criteria) this;
        }

        public Criteria andPlIsNotNull() {
            addCriterion("pl is not null");
            return (Criteria) this;
        }

        public Criteria andPlEqualTo(String value) {
            addCriterion("pl =", value, "pl");
            return (Criteria) this;
        }

        public Criteria andPlNotEqualTo(String value) {
            addCriterion("pl <>", value, "pl");
            return (Criteria) this;
        }

        public Criteria andPlGreaterThan(String value) {
            addCriterion("pl >", value, "pl");
            return (Criteria) this;
        }

        public Criteria andPlGreaterThanOrEqualTo(String value) {
            addCriterion("pl >=", value, "pl");
            return (Criteria) this;
        }

        public Criteria andPlLessThan(String value) {
            addCriterion("pl <", value, "pl");
            return (Criteria) this;
        }

        public Criteria andPlLessThanOrEqualTo(String value) {
            addCriterion("pl <=", value, "pl");
            return (Criteria) this;
        }

        public Criteria andPlLike(String value) {
            addCriterion("pl like", value, "pl");
            return (Criteria) this;
        }

        public Criteria andPlNotLike(String value) {
            addCriterion("pl not like", value, "pl");
            return (Criteria) this;
        }

        public Criteria andPlIn(List<String> values) {
            addCriterion("pl in", values, "pl");
            return (Criteria) this;
        }

        public Criteria andPlNotIn(List<String> values) {
            addCriterion("pl not in", values, "pl");
            return (Criteria) this;
        }

        public Criteria andPlBetween(String value1, String value2) {
            addCriterion("pl between", value1, value2, "pl");
            return (Criteria) this;
        }

        public Criteria andPlNotBetween(String value1, String value2) {
            addCriterion("pl not between", value1, value2, "pl");
            return (Criteria) this;
        }

        public Criteria andLtggIsNull() {
            addCriterion("ltgg is null");
            return (Criteria) this;
        }

        public Criteria andLtggIsNotNull() {
            addCriterion("ltgg is not null");
            return (Criteria) this;
        }

        public Criteria andLtggEqualTo(String value) {
            addCriterion("ltgg =", value, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggNotEqualTo(String value) {
            addCriterion("ltgg <>", value, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggGreaterThan(String value) {
            addCriterion("ltgg >", value, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggGreaterThanOrEqualTo(String value) {
            addCriterion("ltgg >=", value, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggLessThan(String value) {
            addCriterion("ltgg <", value, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggLessThanOrEqualTo(String value) {
            addCriterion("ltgg <=", value, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggLike(String value) {
            addCriterion("ltgg like", value, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggNotLike(String value) {
            addCriterion("ltgg not like", value, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggIn(List<String> values) {
            addCriterion("ltgg in", values, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggNotIn(List<String> values) {
            addCriterion("ltgg not in", values, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggBetween(String value1, String value2) {
            addCriterion("ltgg between", value1, value2, "ltgg");
            return (Criteria) this;
        }

        public Criteria andLtggNotBetween(String value1, String value2) {
            addCriterion("ltgg not between", value1, value2, "ltgg");
            return (Criteria) this;
        }

        public Criteria andHdzksIsNull() {
            addCriterion("hdzks is null");
            return (Criteria) this;
        }

        public Criteria andHdzksIsNotNull() {
            addCriterion("hdzks is not null");
            return (Criteria) this;
        }

        public Criteria andHdzksEqualTo(String value) {
            addCriterion("hdzks =", value, "hdzks");
            return (Criteria) this;
        }

        public Criteria andHdzksNotEqualTo(String value) {
            addCriterion("hdzks <>", value, "hdzks");
            return (Criteria) this;
        }

        public Criteria andHdzksGreaterThan(String value) {
            addCriterion("hdzks >", value, "hdzks");
            return (Criteria) this;
        }

        public Criteria andHdzksGreaterThanOrEqualTo(String value) {
            addCriterion("hdzks >=", value, "hdzks");
            return (Criteria) this;
        }

        public Criteria andHdzksLessThan(String value) {
            addCriterion("hdzks <", value, "hdzks");
            return (Criteria) this;
        }

        public Criteria andHdzksLessThanOrEqualTo(String value) {
            addCriterion("hdzks <=", value, "hdzks");
            return (Criteria) this;
        }

        public Criteria andHdzksLike(String value) {
            addCriterion("hdzks like", value, "hdzks");
            return (Criteria) this;
        }

        public Criteria andHdzksNotLike(String value) {
            addCriterion("hdzks not like", value, "hdzks");
            return (Criteria) this;
        }

        public Criteria andHdzksIn(List<String> values) {
            addCriterion("hdzks in", values, "hdzks");
            return (Criteria) this;
        }

        public Criteria andHdzksNotIn(List<String> values) {
            addCriterion("hdzks not in", values, "hdzks");
            return (Criteria) this;
        }

        public Criteria andHdzksBetween(String value1, String value2) {
            addCriterion("hdzks between", value1, value2, "hdzks");
            return (Criteria) this;
        }

        public Criteria andHdzksNotBetween(String value1, String value2) {
            addCriterion("hdzks not between", value1, value2, "hdzks");
            return (Criteria) this;
        }

        public Criteria andHdfsIsNull() {
            addCriterion("hdfs is null");
            return (Criteria) this;
        }

        public Criteria andHdfsIsNotNull() {
            addCriterion("hdfs is not null");
            return (Criteria) this;
        }

        public Criteria andHdfsEqualTo(Integer value) {
            addCriterion("hdfs =", value, "hdfs");
            return (Criteria) this;
        }

        public Criteria andHdfsNotEqualTo(Integer value) {
            addCriterion("hdfs <>", value, "hdfs");
            return (Criteria) this;
        }

        public Criteria andHdfsGreaterThan(Integer value) {
            addCriterion("hdfs >", value, "hdfs");
            return (Criteria) this;
        }

        public Criteria andHdfsGreaterThanOrEqualTo(Integer value) {
            addCriterion("hdfs >=", value, "hdfs");
            return (Criteria) this;
        }

        public Criteria andHdfsLessThan(Integer value) {
            addCriterion("hdfs <", value, "hdfs");
            return (Criteria) this;
        }

        public Criteria andHdfsLessThanOrEqualTo(Integer value) {
            addCriterion("hdfs <=", value, "hdfs");
            return (Criteria) this;
        }

        public Criteria andHdfsIn(List<Integer> values) {
            addCriterion("hdfs in", values, "hdfs");
            return (Criteria) this;
        }

        public Criteria andHdfsNotIn(List<Integer> values) {
            addCriterion("hdfs not in", values, "hdfs");
            return (Criteria) this;
        }

        public Criteria andHdfsBetween(Integer value1, Integer value2) {
            addCriterion("hdfs between", value1, value2, "hdfs");
            return (Criteria) this;
        }

        public Criteria andHdfsNotBetween(Integer value1, Integer value2) {
            addCriterion("hdfs not between", value1, value2, "hdfs");
            return (Criteria) this;
        }

        public Criteria andZcdIsNull() {
            addCriterion("zcd is null");
            return (Criteria) this;
        }

        public Criteria andZcdIsNotNull() {
            addCriterion("zcd is not null");
            return (Criteria) this;
        }

        public Criteria andZcdEqualTo(String value) {
            addCriterion("zcd =", value, "zcd");
            return (Criteria) this;
        }

        public Criteria andZcdNotEqualTo(String value) {
            addCriterion("zcd <>", value, "zcd");
            return (Criteria) this;
        }

        public Criteria andZcdGreaterThan(String value) {
            addCriterion("zcd >", value, "zcd");
            return (Criteria) this;
        }

        public Criteria andZcdGreaterThanOrEqualTo(String value) {
            addCriterion("zcd >=", value, "zcd");
            return (Criteria) this;
        }

        public Criteria andZcdLessThan(String value) {
            addCriterion("zcd <", value, "zcd");
            return (Criteria) this;
        }

        public Criteria andZcdLessThanOrEqualTo(String value) {
            addCriterion("zcd <=", value, "zcd");
            return (Criteria) this;
        }

        public Criteria andZcdLike(String value) {
            addCriterion("zcd like", value, "zcd");
            return (Criteria) this;
        }

        public Criteria andZcdNotLike(String value) {
            addCriterion("zcd not like", value, "zcd");
            return (Criteria) this;
        }

        public Criteria andZcdIn(List<String> values) {
            addCriterion("zcd in", values, "zcd");
            return (Criteria) this;
        }

        public Criteria andZcdNotIn(List<String> values) {
            addCriterion("zcd not in", values, "zcd");
            return (Criteria) this;
        }

        public Criteria andZcdBetween(String value1, String value2) {
            addCriterion("zcd between", value1, value2, "zcd");
            return (Criteria) this;
        }

        public Criteria andZcdNotBetween(String value1, String value2) {
            addCriterion("zcd not between", value1, value2, "zcd");
            return (Criteria) this;
        }

        public Criteria andCdrqIsNull() {
            addCriterion("cdrq is null");
            return (Criteria) this;
        }

        public Criteria andCdrqIsNotNull() {
            addCriterion("cdrq is not null");
            return (Criteria) this;
        }

        public Criteria andCdrqEqualTo(String value) {
            addCriterion("cdrq =", value, "cdrq");
            return (Criteria) this;
        }

        public Criteria andCdrqNotEqualTo(String value) {
            addCriterion("cdrq <>", value, "cdrq");
            return (Criteria) this;
        }

        public Criteria andCdrqGreaterThan(String value) {
            addCriterion("cdrq >", value, "cdrq");
            return (Criteria) this;
        }

        public Criteria andCdrqGreaterThanOrEqualTo(String value) {
            addCriterion("cdrq >=", value, "cdrq");
            return (Criteria) this;
        }

        public Criteria andCdrqLessThan(String value) {
            addCriterion("cdrq <", value, "cdrq");
            return (Criteria) this;
        }

        public Criteria andCdrqLessThanOrEqualTo(String value) {
            addCriterion("cdrq <=", value, "cdrq");
            return (Criteria) this;
        }

        public Criteria andCdrqLike(String value) {
            addCriterion("cdrq like", value, "cdrq");
            return (Criteria) this;
        }

        public Criteria andCdrqNotLike(String value) {
            addCriterion("cdrq not like", value, "cdrq");
            return (Criteria) this;
        }

        public Criteria andCdrqIn(List<String> values) {
            addCriterion("cdrq in", values, "cdrq");
            return (Criteria) this;
        }

        public Criteria andCdrqNotIn(List<String> values) {
            addCriterion("cdrq not in", values, "cdrq");
            return (Criteria) this;
        }

        public Criteria andCdrqBetween(String value1, String value2) {
            addCriterion("cdrq between", value1, value2, "cdrq");
            return (Criteria) this;
        }

        public Criteria andCdrqNotBetween(String value1, String value2) {
            addCriterion("cdrq not between", value1, value2, "cdrq");
            return (Criteria) this;
        }

        public Criteria andCcrqIsNull() {
            addCriterion("ccrq is null");
            return (Criteria) this;
        }

        public Criteria andCcrqIsNotNull() {
            addCriterion("ccrq is not null");
            return (Criteria) this;
        }

        public Criteria andCcrqEqualTo(String value) {
            addCriterion("ccrq =", value, "ccrq");
            return (Criteria) this;
        }

        public Criteria andCcrqNotEqualTo(String value) {
            addCriterion("ccrq <>", value, "ccrq");
            return (Criteria) this;
        }

        public Criteria andCcrqGreaterThan(String value) {
            addCriterion("ccrq >", value, "ccrq");
            return (Criteria) this;
        }

        public Criteria andCcrqGreaterThanOrEqualTo(String value) {
            addCriterion("ccrq >=", value, "ccrq");
            return (Criteria) this;
        }

        public Criteria andCcrqLessThan(String value) {
            addCriterion("ccrq <", value, "ccrq");
            return (Criteria) this;
        }

        public Criteria andCcrqLessThanOrEqualTo(String value) {
            addCriterion("ccrq <=", value, "ccrq");
            return (Criteria) this;
        }

        public Criteria andCcrqLike(String value) {
            addCriterion("ccrq like", value, "ccrq");
            return (Criteria) this;
        }

        public Criteria andCcrqNotLike(String value) {
            addCriterion("ccrq not like", value, "ccrq");
            return (Criteria) this;
        }

        public Criteria andCcrqIn(List<String> values) {
            addCriterion("ccrq in", values, "ccrq");
            return (Criteria) this;
        }

        public Criteria andCcrqNotIn(List<String> values) {
            addCriterion("ccrq not in", values, "ccrq");
            return (Criteria) this;
        }

        public Criteria andCcrqBetween(String value1, String value2) {
            addCriterion("ccrq between", value1, value2, "ccrq");
            return (Criteria) this;
        }

        public Criteria andCcrqNotBetween(String value1, String value2) {
            addCriterion("ccrq not between", value1, value2, "ccrq");
            return (Criteria) this;
        }

        public Criteria andGhcsIsNull() {
            addCriterion("ghcs is null");
            return (Criteria) this;
        }

        public Criteria andGhcsIsNotNull() {
            addCriterion("ghcs is not null");
            return (Criteria) this;
        }

        public Criteria andGhcsEqualTo(String value) {
            addCriterion("ghcs =", value, "ghcs");
            return (Criteria) this;
        }

        public Criteria andGhcsNotEqualTo(String value) {
            addCriterion("ghcs <>", value, "ghcs");
            return (Criteria) this;
        }

        public Criteria andGhcsGreaterThan(String value) {
            addCriterion("ghcs >", value, "ghcs");
            return (Criteria) this;
        }

        public Criteria andGhcsGreaterThanOrEqualTo(String value) {
            addCriterion("ghcs >=", value, "ghcs");
            return (Criteria) this;
        }

        public Criteria andGhcsLessThan(String value) {
            addCriterion("ghcs <", value, "ghcs");
            return (Criteria) this;
        }

        public Criteria andGhcsLessThanOrEqualTo(String value) {
            addCriterion("ghcs <=", value, "ghcs");
            return (Criteria) this;
        }

        public Criteria andGhcsLike(String value) {
            addCriterion("ghcs like", value, "ghcs");
            return (Criteria) this;
        }

        public Criteria andGhcsNotLike(String value) {
            addCriterion("ghcs not like", value, "ghcs");
            return (Criteria) this;
        }

        public Criteria andGhcsIn(List<String> values) {
            addCriterion("ghcs in", values, "ghcs");
            return (Criteria) this;
        }

        public Criteria andGhcsNotIn(List<String> values) {
            addCriterion("ghcs not in", values, "ghcs");
            return (Criteria) this;
        }

        public Criteria andGhcsBetween(String value1, String value2) {
            addCriterion("ghcs between", value1, value2, "ghcs");
            return (Criteria) this;
        }

        public Criteria andGhcsNotBetween(String value1, String value2) {
            addCriterion("ghcs not between", value1, value2, "ghcs");
            return (Criteria) this;
        }

        public Criteria andZhghsjIsNull() {
            addCriterion("zhghsj is null");
            return (Criteria) this;
        }

        public Criteria andZhghsjIsNotNull() {
            addCriterion("zhghsj is not null");
            return (Criteria) this;
        }

        public Criteria andZhghsjEqualTo(String value) {
            addCriterion("zhghsj =", value, "zhghsj");
            return (Criteria) this;
        }

        public Criteria andZhghsjNotEqualTo(String value) {
            addCriterion("zhghsj <>", value, "zhghsj");
            return (Criteria) this;
        }

        public Criteria andZhghsjGreaterThan(String value) {
            addCriterion("zhghsj >", value, "zhghsj");
            return (Criteria) this;
        }

        public Criteria andZhghsjGreaterThanOrEqualTo(String value) {
            addCriterion("zhghsj >=", value, "zhghsj");
            return (Criteria) this;
        }

        public Criteria andZhghsjLessThan(String value) {
            addCriterion("zhghsj <", value, "zhghsj");
            return (Criteria) this;
        }

        public Criteria andZhghsjLessThanOrEqualTo(String value) {
            addCriterion("zhghsj <=", value, "zhghsj");
            return (Criteria) this;
        }

        public Criteria andZhghsjLike(String value) {
            addCriterion("zhghsj like", value, "zhghsj");
            return (Criteria) this;
        }

        public Criteria andZhghsjNotLike(String value) {
            addCriterion("zhghsj not like", value, "zhghsj");
            return (Criteria) this;
        }

        public Criteria andZhghsjIn(List<String> values) {
            addCriterion("zhghsj in", values, "zhghsj");
            return (Criteria) this;
        }

        public Criteria andZhghsjNotIn(List<String> values) {
            addCriterion("zhghsj not in", values, "zhghsj");
            return (Criteria) this;
        }

        public Criteria andZhghsjBetween(String value1, String value2) {
            addCriterion("zhghsj between", value1, value2, "zhghsj");
            return (Criteria) this;
        }

        public Criteria andZhghsjNotBetween(String value1, String value2) {
            addCriterion("zhghsj not between", value1, value2, "zhghsj");
            return (Criteria) this;
        }

        public Criteria andYzrdIsNull() {
            addCriterion("yzrd is null");
            return (Criteria) this;
        }

        public Criteria andYzrdIsNotNull() {
            addCriterion("yzrd is not null");
            return (Criteria) this;
        }

        public Criteria andYzrdEqualTo(String value) {
            addCriterion("yzrd =", value, "yzrd");
            return (Criteria) this;
        }

        public Criteria andYzrdNotEqualTo(String value) {
            addCriterion("yzrd <>", value, "yzrd");
            return (Criteria) this;
        }

        public Criteria andYzrdGreaterThan(String value) {
            addCriterion("yzrd >", value, "yzrd");
            return (Criteria) this;
        }

        public Criteria andYzrdGreaterThanOrEqualTo(String value) {
            addCriterion("yzrd >=", value, "yzrd");
            return (Criteria) this;
        }

        public Criteria andYzrdLessThan(String value) {
            addCriterion("yzrd <", value, "yzrd");
            return (Criteria) this;
        }

        public Criteria andYzrdLessThanOrEqualTo(String value) {
            addCriterion("yzrd <=", value, "yzrd");
            return (Criteria) this;
        }

        public Criteria andYzrdLike(String value) {
            addCriterion("yzrd like", value, "yzrd");
            return (Criteria) this;
        }

        public Criteria andYzrdNotLike(String value) {
            addCriterion("yzrd not like", value, "yzrd");
            return (Criteria) this;
        }

        public Criteria andYzrdIn(List<String> values) {
            addCriterion("yzrd in", values, "yzrd");
            return (Criteria) this;
        }

        public Criteria andYzrdNotIn(List<String> values) {
            addCriterion("yzrd not in", values, "yzrd");
            return (Criteria) this;
        }

        public Criteria andYzrdBetween(String value1, String value2) {
            addCriterion("yzrd between", value1, value2, "yzrd");
            return (Criteria) this;
        }

        public Criteria andYzrdNotBetween(String value1, String value2) {
            addCriterion("yzrd not between", value1, value2, "yzrd");
            return (Criteria) this;
        }

        public Criteria andYsyfIsNull() {
            addCriterion("ysyf is null");
            return (Criteria) this;
        }

        public Criteria andYsyfIsNotNull() {
            addCriterion("ysyf is not null");
            return (Criteria) this;
        }

        public Criteria andYsyfEqualTo(Integer value) {
            addCriterion("ysyf =", value, "ysyf");
            return (Criteria) this;
        }

        public Criteria andYsyfNotEqualTo(Integer value) {
            addCriterion("ysyf <>", value, "ysyf");
            return (Criteria) this;
        }

        public Criteria andYsyfGreaterThan(Integer value) {
            addCriterion("ysyf >", value, "ysyf");
            return (Criteria) this;
        }

        public Criteria andYsyfGreaterThanOrEqualTo(Integer value) {
            addCriterion("ysyf >=", value, "ysyf");
            return (Criteria) this;
        }

        public Criteria andYsyfLessThan(Integer value) {
            addCriterion("ysyf <", value, "ysyf");
            return (Criteria) this;
        }

        public Criteria andYsyfLessThanOrEqualTo(Integer value) {
            addCriterion("ysyf <=", value, "ysyf");
            return (Criteria) this;
        }

        public Criteria andYsyfIn(List<Integer> values) {
            addCriterion("ysyf in", values, "ysyf");
            return (Criteria) this;
        }

        public Criteria andYsyfNotIn(List<Integer> values) {
            addCriterion("ysyf not in", values, "ysyf");
            return (Criteria) this;
        }

        public Criteria andYsyfBetween(Integer value1, Integer value2) {
            addCriterion("ysyf between", value1, value2, "ysyf");
            return (Criteria) this;
        }

        public Criteria andYsyfNotBetween(Integer value1, Integer value2) {
            addCriterion("ysyf not between", value1, value2, "ysyf");
            return (Criteria) this;
        }

        public Criteria andXsyfIsNull() {
            addCriterion("xsyf is null");
            return (Criteria) this;
        }

        public Criteria andXsyfIsNotNull() {
            addCriterion("xsyf is not null");
            return (Criteria) this;
        }

        public Criteria andXsyfEqualTo(Integer value) {
            addCriterion("xsyf =", value, "xsyf");
            return (Criteria) this;
        }

        public Criteria andXsyfNotEqualTo(Integer value) {
            addCriterion("xsyf <>", value, "xsyf");
            return (Criteria) this;
        }

        public Criteria andXsyfGreaterThan(Integer value) {
            addCriterion("xsyf >", value, "xsyf");
            return (Criteria) this;
        }

        public Criteria andXsyfGreaterThanOrEqualTo(Integer value) {
            addCriterion("xsyf >=", value, "xsyf");
            return (Criteria) this;
        }

        public Criteria andXsyfLessThan(Integer value) {
            addCriterion("xsyf <", value, "xsyf");
            return (Criteria) this;
        }

        public Criteria andXsyfLessThanOrEqualTo(Integer value) {
            addCriterion("xsyf <=", value, "xsyf");
            return (Criteria) this;
        }

        public Criteria andXsyfIn(List<Integer> values) {
            addCriterion("xsyf in", values, "xsyf");
            return (Criteria) this;
        }

        public Criteria andXsyfNotIn(List<Integer> values) {
            addCriterion("xsyf not in", values, "xsyf");
            return (Criteria) this;
        }

        public Criteria andXsyfBetween(Integer value1, Integer value2) {
            addCriterion("xsyf between", value1, value2, "xsyf");
            return (Criteria) this;
        }

        public Criteria andXsyfNotBetween(Integer value1, Integer value2) {
            addCriterion("xsyf not between", value1, value2, "xsyf");
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