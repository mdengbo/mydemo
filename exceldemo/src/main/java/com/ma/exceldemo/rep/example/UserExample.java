package com.ma.exceldemo.rep.example;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
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

        public Criteria andBranchIsNull() {
            addCriterion("branch is null");
            return (Criteria) this;
        }

        public Criteria andBranchIsNotNull() {
            addCriterion("branch is not null");
            return (Criteria) this;
        }

        public Criteria andBranchEqualTo(String value) {
            addCriterion("branch =", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchNotEqualTo(String value) {
            addCriterion("branch <>", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchGreaterThan(String value) {
            addCriterion("branch >", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchGreaterThanOrEqualTo(String value) {
            addCriterion("branch >=", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchLessThan(String value) {
            addCriterion("branch <", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchLessThanOrEqualTo(String value) {
            addCriterion("branch <=", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchLike(String value) {
            addCriterion("branch like", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchNotLike(String value) {
            addCriterion("branch not like", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchIn(List<String> values) {
            addCriterion("branch in", values, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchNotIn(List<String> values) {
            addCriterion("branch not in", values, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchBetween(String value1, String value2) {
            addCriterion("branch between", value1, value2, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchNotBetween(String value1, String value2) {
            addCriterion("branch not between", value1, value2, "branch");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNull() {
            addCriterion("IDcard is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNotNull() {
            addCriterion("IDcard is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardEqualTo(String value) {
            addCriterion("IDcard =", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotEqualTo(String value) {
            addCriterion("IDcard <>", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThan(String value) {
            addCriterion("IDcard >", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("IDcard >=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThan(String value) {
            addCriterion("IDcard <", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThanOrEqualTo(String value) {
            addCriterion("IDcard <=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLike(String value) {
            addCriterion("IDcard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLike(String value) {
            addCriterion("IDcard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardIn(List<String> values) {
            addCriterion("IDcard in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotIn(List<String> values) {
            addCriterion("IDcard not in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardBetween(String value1, String value2) {
            addCriterion("IDcard between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotBetween(String value1, String value2) {
            addCriterion("IDcard not between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andXingzhengbanIsNull() {
            addCriterion("xingzhengban is null");
            return (Criteria) this;
        }

        public Criteria andXingzhengbanIsNotNull() {
            addCriterion("xingzhengban is not null");
            return (Criteria) this;
        }

        public Criteria andXingzhengbanEqualTo(String value) {
            addCriterion("xingzhengban =", value, "xingzhengban");
            return (Criteria) this;
        }

        public Criteria andXingzhengbanNotEqualTo(String value) {
            addCriterion("xingzhengban <>", value, "xingzhengban");
            return (Criteria) this;
        }

        public Criteria andXingzhengbanGreaterThan(String value) {
            addCriterion("xingzhengban >", value, "xingzhengban");
            return (Criteria) this;
        }

        public Criteria andXingzhengbanGreaterThanOrEqualTo(String value) {
            addCriterion("xingzhengban >=", value, "xingzhengban");
            return (Criteria) this;
        }

        public Criteria andXingzhengbanLessThan(String value) {
            addCriterion("xingzhengban <", value, "xingzhengban");
            return (Criteria) this;
        }

        public Criteria andXingzhengbanLessThanOrEqualTo(String value) {
            addCriterion("xingzhengban <=", value, "xingzhengban");
            return (Criteria) this;
        }

        public Criteria andXingzhengbanLike(String value) {
            addCriterion("xingzhengban like", value, "xingzhengban");
            return (Criteria) this;
        }

        public Criteria andXingzhengbanNotLike(String value) {
            addCriterion("xingzhengban not like", value, "xingzhengban");
            return (Criteria) this;
        }

        public Criteria andXingzhengbanIn(List<String> values) {
            addCriterion("xingzhengban in", values, "xingzhengban");
            return (Criteria) this;
        }

        public Criteria andXingzhengbanNotIn(List<String> values) {
            addCriterion("xingzhengban not in", values, "xingzhengban");
            return (Criteria) this;
        }

        public Criteria andXingzhengbanBetween(String value1, String value2) {
            addCriterion("xingzhengban between", value1, value2, "xingzhengban");
            return (Criteria) this;
        }

        public Criteria andXingzhengbanNotBetween(String value1, String value2) {
            addCriterion("xingzhengban not between", value1, value2, "xingzhengban");
            return (Criteria) this;
        }

        public Criteria andJiguanIsNull() {
            addCriterion("jiguan is null");
            return (Criteria) this;
        }

        public Criteria andJiguanIsNotNull() {
            addCriterion("jiguan is not null");
            return (Criteria) this;
        }

        public Criteria andJiguanEqualTo(String value) {
            addCriterion("jiguan =", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanNotEqualTo(String value) {
            addCriterion("jiguan <>", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanGreaterThan(String value) {
            addCriterion("jiguan >", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanGreaterThanOrEqualTo(String value) {
            addCriterion("jiguan >=", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanLessThan(String value) {
            addCriterion("jiguan <", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanLessThanOrEqualTo(String value) {
            addCriterion("jiguan <=", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanLike(String value) {
            addCriterion("jiguan like", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanNotLike(String value) {
            addCriterion("jiguan not like", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanIn(List<String> values) {
            addCriterion("jiguan in", values, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanNotIn(List<String> values) {
            addCriterion("jiguan not in", values, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanBetween(String value1, String value2) {
            addCriterion("jiguan between", value1, value2, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanNotBetween(String value1, String value2) {
            addCriterion("jiguan not between", value1, value2, "jiguan");
            return (Criteria) this;
        }

        public Criteria andBiyezhongxueIsNull() {
            addCriterion("biyezhongxue is null");
            return (Criteria) this;
        }

        public Criteria andBiyezhongxueIsNotNull() {
            addCriterion("biyezhongxue is not null");
            return (Criteria) this;
        }

        public Criteria andBiyezhongxueEqualTo(String value) {
            addCriterion("biyezhongxue =", value, "biyezhongxue");
            return (Criteria) this;
        }

        public Criteria andBiyezhongxueNotEqualTo(String value) {
            addCriterion("biyezhongxue <>", value, "biyezhongxue");
            return (Criteria) this;
        }

        public Criteria andBiyezhongxueGreaterThan(String value) {
            addCriterion("biyezhongxue >", value, "biyezhongxue");
            return (Criteria) this;
        }

        public Criteria andBiyezhongxueGreaterThanOrEqualTo(String value) {
            addCriterion("biyezhongxue >=", value, "biyezhongxue");
            return (Criteria) this;
        }

        public Criteria andBiyezhongxueLessThan(String value) {
            addCriterion("biyezhongxue <", value, "biyezhongxue");
            return (Criteria) this;
        }

        public Criteria andBiyezhongxueLessThanOrEqualTo(String value) {
            addCriterion("biyezhongxue <=", value, "biyezhongxue");
            return (Criteria) this;
        }

        public Criteria andBiyezhongxueLike(String value) {
            addCriterion("biyezhongxue like", value, "biyezhongxue");
            return (Criteria) this;
        }

        public Criteria andBiyezhongxueNotLike(String value) {
            addCriterion("biyezhongxue not like", value, "biyezhongxue");
            return (Criteria) this;
        }

        public Criteria andBiyezhongxueIn(List<String> values) {
            addCriterion("biyezhongxue in", values, "biyezhongxue");
            return (Criteria) this;
        }

        public Criteria andBiyezhongxueNotIn(List<String> values) {
            addCriterion("biyezhongxue not in", values, "biyezhongxue");
            return (Criteria) this;
        }

        public Criteria andBiyezhongxueBetween(String value1, String value2) {
            addCriterion("biyezhongxue between", value1, value2, "biyezhongxue");
            return (Criteria) this;
        }

        public Criteria andBiyezhongxueNotBetween(String value1, String value2) {
            addCriterion("biyezhongxue not between", value1, value2, "biyezhongxue");
            return (Criteria) this;
        }

        public Criteria andPhone1IsNull() {
            addCriterion("phone1 is null");
            return (Criteria) this;
        }

        public Criteria andPhone1IsNotNull() {
            addCriterion("phone1 is not null");
            return (Criteria) this;
        }

        public Criteria andPhone1EqualTo(String value) {
            addCriterion("phone1 =", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1NotEqualTo(String value) {
            addCriterion("phone1 <>", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1GreaterThan(String value) {
            addCriterion("phone1 >", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1GreaterThanOrEqualTo(String value) {
            addCriterion("phone1 >=", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1LessThan(String value) {
            addCriterion("phone1 <", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1LessThanOrEqualTo(String value) {
            addCriterion("phone1 <=", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1Like(String value) {
            addCriterion("phone1 like", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1NotLike(String value) {
            addCriterion("phone1 not like", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1In(List<String> values) {
            addCriterion("phone1 in", values, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1NotIn(List<String> values) {
            addCriterion("phone1 not in", values, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1Between(String value1, String value2) {
            addCriterion("phone1 between", value1, value2, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1NotBetween(String value1, String value2) {
            addCriterion("phone1 not between", value1, value2, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone2IsNull() {
            addCriterion("phone2 is null");
            return (Criteria) this;
        }

        public Criteria andPhone2IsNotNull() {
            addCriterion("phone2 is not null");
            return (Criteria) this;
        }

        public Criteria andPhone2EqualTo(String value) {
            addCriterion("phone2 =", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2NotEqualTo(String value) {
            addCriterion("phone2 <>", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2GreaterThan(String value) {
            addCriterion("phone2 >", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2GreaterThanOrEqualTo(String value) {
            addCriterion("phone2 >=", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2LessThan(String value) {
            addCriterion("phone2 <", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2LessThanOrEqualTo(String value) {
            addCriterion("phone2 <=", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2Like(String value) {
            addCriterion("phone2 like", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2NotLike(String value) {
            addCriterion("phone2 not like", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2In(List<String> values) {
            addCriterion("phone2 in", values, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2NotIn(List<String> values) {
            addCriterion("phone2 not in", values, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2Between(String value1, String value2) {
            addCriterion("phone2 between", value1, value2, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2NotBetween(String value1, String value2) {
            addCriterion("phone2 not between", value1, value2, "phone2");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
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