package com.maizhong.auction.pojo;

import java.util.ArrayList;
import java.util.List;

public class CkXszExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CkXszExample() {
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

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("number not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andLxIsNull() {
            addCriterion("lx is null");
            return (Criteria) this;
        }

        public Criteria andLxIsNotNull() {
            addCriterion("lx is not null");
            return (Criteria) this;
        }

        public Criteria andLxEqualTo(Integer value) {
            addCriterion("lx =", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxNotEqualTo(Integer value) {
            addCriterion("lx <>", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxGreaterThan(Integer value) {
            addCriterion("lx >", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxGreaterThanOrEqualTo(Integer value) {
            addCriterion("lx >=", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxLessThan(Integer value) {
            addCriterion("lx <", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxLessThanOrEqualTo(Integer value) {
            addCriterion("lx <=", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxIn(List<Integer> values) {
            addCriterion("lx in", values, "lx");
            return (Criteria) this;
        }

        public Criteria andLxNotIn(List<Integer> values) {
            addCriterion("lx not in", values, "lx");
            return (Criteria) this;
        }

        public Criteria andLxBetween(Integer value1, Integer value2) {
            addCriterion("lx between", value1, value2, "lx");
            return (Criteria) this;
        }

        public Criteria andLxNotBetween(Integer value1, Integer value2) {
            addCriterion("lx not between", value1, value2, "lx");
            return (Criteria) this;
        }

        public Criteria andXzIsNull() {
            addCriterion("xz is null");
            return (Criteria) this;
        }

        public Criteria andXzIsNotNull() {
            addCriterion("xz is not null");
            return (Criteria) this;
        }

        public Criteria andXzEqualTo(Integer value) {
            addCriterion("xz =", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzNotEqualTo(Integer value) {
            addCriterion("xz <>", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzGreaterThan(Integer value) {
            addCriterion("xz >", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzGreaterThanOrEqualTo(Integer value) {
            addCriterion("xz >=", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzLessThan(Integer value) {
            addCriterion("xz <", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzLessThanOrEqualTo(Integer value) {
            addCriterion("xz <=", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzIn(List<Integer> values) {
            addCriterion("xz in", values, "xz");
            return (Criteria) this;
        }

        public Criteria andXzNotIn(List<Integer> values) {
            addCriterion("xz not in", values, "xz");
            return (Criteria) this;
        }

        public Criteria andXzBetween(Integer value1, Integer value2) {
            addCriterion("xz between", value1, value2, "xz");
            return (Criteria) this;
        }

        public Criteria andXzNotBetween(Integer value1, Integer value2) {
            addCriterion("xz not between", value1, value2, "xz");
            return (Criteria) this;
        }

        public Criteria andPpxhIsNull() {
            addCriterion("ppxh is null");
            return (Criteria) this;
        }

        public Criteria andPpxhIsNotNull() {
            addCriterion("ppxh is not null");
            return (Criteria) this;
        }

        public Criteria andPpxhEqualTo(String value) {
            addCriterion("ppxh =", value, "ppxh");
            return (Criteria) this;
        }

        public Criteria andPpxhNotEqualTo(String value) {
            addCriterion("ppxh <>", value, "ppxh");
            return (Criteria) this;
        }

        public Criteria andPpxhGreaterThan(String value) {
            addCriterion("ppxh >", value, "ppxh");
            return (Criteria) this;
        }

        public Criteria andPpxhGreaterThanOrEqualTo(String value) {
            addCriterion("ppxh >=", value, "ppxh");
            return (Criteria) this;
        }

        public Criteria andPpxhLessThan(String value) {
            addCriterion("ppxh <", value, "ppxh");
            return (Criteria) this;
        }

        public Criteria andPpxhLessThanOrEqualTo(String value) {
            addCriterion("ppxh <=", value, "ppxh");
            return (Criteria) this;
        }

        public Criteria andPpxhLike(String value) {
            addCriterion("ppxh like", value, "ppxh");
            return (Criteria) this;
        }

        public Criteria andPpxhNotLike(String value) {
            addCriterion("ppxh not like", value, "ppxh");
            return (Criteria) this;
        }

        public Criteria andPpxhIn(List<String> values) {
            addCriterion("ppxh in", values, "ppxh");
            return (Criteria) this;
        }

        public Criteria andPpxhNotIn(List<String> values) {
            addCriterion("ppxh not in", values, "ppxh");
            return (Criteria) this;
        }

        public Criteria andPpxhBetween(String value1, String value2) {
            addCriterion("ppxh between", value1, value2, "ppxh");
            return (Criteria) this;
        }

        public Criteria andPpxhNotBetween(String value1, String value2) {
            addCriterion("ppxh not between", value1, value2, "ppxh");
            return (Criteria) this;
        }

        public Criteria andCjhIsNull() {
            addCriterion("cjh is null");
            return (Criteria) this;
        }

        public Criteria andCjhIsNotNull() {
            addCriterion("cjh is not null");
            return (Criteria) this;
        }

        public Criteria andCjhEqualTo(String value) {
            addCriterion("cjh =", value, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhNotEqualTo(String value) {
            addCriterion("cjh <>", value, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhGreaterThan(String value) {
            addCriterion("cjh >", value, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhGreaterThanOrEqualTo(String value) {
            addCriterion("cjh >=", value, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhLessThan(String value) {
            addCriterion("cjh <", value, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhLessThanOrEqualTo(String value) {
            addCriterion("cjh <=", value, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhLike(String value) {
            addCriterion("cjh like", value, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhNotLike(String value) {
            addCriterion("cjh not like", value, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhIn(List<String> values) {
            addCriterion("cjh in", values, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhNotIn(List<String> values) {
            addCriterion("cjh not in", values, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhBetween(String value1, String value2) {
            addCriterion("cjh between", value1, value2, "cjh");
            return (Criteria) this;
        }

        public Criteria andCjhNotBetween(String value1, String value2) {
            addCriterion("cjh not between", value1, value2, "cjh");
            return (Criteria) this;
        }

        public Criteria andFdjhIsNull() {
            addCriterion("fdjh is null");
            return (Criteria) this;
        }

        public Criteria andFdjhIsNotNull() {
            addCriterion("fdjh is not null");
            return (Criteria) this;
        }

        public Criteria andFdjhEqualTo(String value) {
            addCriterion("fdjh =", value, "fdjh");
            return (Criteria) this;
        }

        public Criteria andFdjhNotEqualTo(String value) {
            addCriterion("fdjh <>", value, "fdjh");
            return (Criteria) this;
        }

        public Criteria andFdjhGreaterThan(String value) {
            addCriterion("fdjh >", value, "fdjh");
            return (Criteria) this;
        }

        public Criteria andFdjhGreaterThanOrEqualTo(String value) {
            addCriterion("fdjh >=", value, "fdjh");
            return (Criteria) this;
        }

        public Criteria andFdjhLessThan(String value) {
            addCriterion("fdjh <", value, "fdjh");
            return (Criteria) this;
        }

        public Criteria andFdjhLessThanOrEqualTo(String value) {
            addCriterion("fdjh <=", value, "fdjh");
            return (Criteria) this;
        }

        public Criteria andFdjhLike(String value) {
            addCriterion("fdjh like", value, "fdjh");
            return (Criteria) this;
        }

        public Criteria andFdjhNotLike(String value) {
            addCriterion("fdjh not like", value, "fdjh");
            return (Criteria) this;
        }

        public Criteria andFdjhIn(List<String> values) {
            addCriterion("fdjh in", values, "fdjh");
            return (Criteria) this;
        }

        public Criteria andFdjhNotIn(List<String> values) {
            addCriterion("fdjh not in", values, "fdjh");
            return (Criteria) this;
        }

        public Criteria andFdjhBetween(String value1, String value2) {
            addCriterion("fdjh between", value1, value2, "fdjh");
            return (Criteria) this;
        }

        public Criteria andFdjhNotBetween(String value1, String value2) {
            addCriterion("fdjh not between", value1, value2, "fdjh");
            return (Criteria) this;
        }

        public Criteria andNjhIsNull() {
            addCriterion("njh is null");
            return (Criteria) this;
        }

        public Criteria andNjhIsNotNull() {
            addCriterion("njh is not null");
            return (Criteria) this;
        }

        public Criteria andNjhEqualTo(String value) {
            addCriterion("njh =", value, "njh");
            return (Criteria) this;
        }

        public Criteria andNjhNotEqualTo(String value) {
            addCriterion("njh <>", value, "njh");
            return (Criteria) this;
        }

        public Criteria andNjhGreaterThan(String value) {
            addCriterion("njh >", value, "njh");
            return (Criteria) this;
        }

        public Criteria andNjhGreaterThanOrEqualTo(String value) {
            addCriterion("njh >=", value, "njh");
            return (Criteria) this;
        }

        public Criteria andNjhLessThan(String value) {
            addCriterion("njh <", value, "njh");
            return (Criteria) this;
        }

        public Criteria andNjhLessThanOrEqualTo(String value) {
            addCriterion("njh <=", value, "njh");
            return (Criteria) this;
        }

        public Criteria andNjhLike(String value) {
            addCriterion("njh like", value, "njh");
            return (Criteria) this;
        }

        public Criteria andNjhNotLike(String value) {
            addCriterion("njh not like", value, "njh");
            return (Criteria) this;
        }

        public Criteria andNjhIn(List<String> values) {
            addCriterion("njh in", values, "njh");
            return (Criteria) this;
        }

        public Criteria andNjhNotIn(List<String> values) {
            addCriterion("njh not in", values, "njh");
            return (Criteria) this;
        }

        public Criteria andNjhBetween(String value1, String value2) {
            addCriterion("njh between", value1, value2, "njh");
            return (Criteria) this;
        }

        public Criteria andNjhNotBetween(String value1, String value2) {
            addCriterion("njh not between", value1, value2, "njh");
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