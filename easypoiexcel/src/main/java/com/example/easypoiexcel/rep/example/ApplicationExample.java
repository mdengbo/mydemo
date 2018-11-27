package com.example.easypoiexcel.rep.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplicationExample() {
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

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppSecretIsNull() {
            addCriterion("app_secret is null");
            return (Criteria) this;
        }

        public Criteria andAppSecretIsNotNull() {
            addCriterion("app_secret is not null");
            return (Criteria) this;
        }

        public Criteria andAppSecretEqualTo(String value) {
            addCriterion("app_secret =", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotEqualTo(String value) {
            addCriterion("app_secret <>", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretGreaterThan(String value) {
            addCriterion("app_secret >", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretGreaterThanOrEqualTo(String value) {
            addCriterion("app_secret >=", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLessThan(String value) {
            addCriterion("app_secret <", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLessThanOrEqualTo(String value) {
            addCriterion("app_secret <=", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLike(String value) {
            addCriterion("app_secret like", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotLike(String value) {
            addCriterion("app_secret not like", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretIn(List<String> values) {
            addCriterion("app_secret in", values, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotIn(List<String> values) {
            addCriterion("app_secret not in", values, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretBetween(String value1, String value2) {
            addCriterion("app_secret between", value1, value2, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotBetween(String value1, String value2) {
            addCriterion("app_secret not between", value1, value2, "appSecret");
            return (Criteria) this;
        }

        public Criteria andIndexUrlIsNull() {
            addCriterion("index_url is null");
            return (Criteria) this;
        }

        public Criteria andIndexUrlIsNotNull() {
            addCriterion("index_url is not null");
            return (Criteria) this;
        }

        public Criteria andIndexUrlEqualTo(String value) {
            addCriterion("index_url =", value, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlNotEqualTo(String value) {
            addCriterion("index_url <>", value, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlGreaterThan(String value) {
            addCriterion("index_url >", value, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlGreaterThanOrEqualTo(String value) {
            addCriterion("index_url >=", value, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlLessThan(String value) {
            addCriterion("index_url <", value, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlLessThanOrEqualTo(String value) {
            addCriterion("index_url <=", value, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlLike(String value) {
            addCriterion("index_url like", value, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlNotLike(String value) {
            addCriterion("index_url not like", value, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlIn(List<String> values) {
            addCriterion("index_url in", values, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlNotIn(List<String> values) {
            addCriterion("index_url not in", values, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlBetween(String value1, String value2) {
            addCriterion("index_url between", value1, value2, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andIndexUrlNotBetween(String value1, String value2) {
            addCriterion("index_url not between", value1, value2, "indexUrl");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name_ is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name_ is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name_ =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name_ <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name_ >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name_ >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name_ <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name_ <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name_ like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name_ not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name_ in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name_ not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name_ between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name_ not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNull() {
            addCriterion("logo_url is null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNotNull() {
            addCriterion("logo_url is not null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlEqualTo(String value) {
            addCriterion("logo_url =", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotEqualTo(String value) {
            addCriterion("logo_url <>", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThan(String value) {
            addCriterion("logo_url >", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("logo_url >=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThan(String value) {
            addCriterion("logo_url <", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThanOrEqualTo(String value) {
            addCriterion("logo_url <=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLike(String value) {
            addCriterion("logo_url like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotLike(String value) {
            addCriterion("logo_url not like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIn(List<String> values) {
            addCriterion("logo_url in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotIn(List<String> values) {
            addCriterion("logo_url not in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlBetween(String value1, String value2) {
            addCriterion("logo_url between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotBetween(String value1, String value2) {
            addCriterion("logo_url not between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andDescIsNull() {
            addCriterion("desc_ is null");
            return (Criteria) this;
        }

        public Criteria andDescIsNotNull() {
            addCriterion("desc_ is not null");
            return (Criteria) this;
        }

        public Criteria andDescEqualTo(String value) {
            addCriterion("desc_ =", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotEqualTo(String value) {
            addCriterion("desc_ <>", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThan(String value) {
            addCriterion("desc_ >", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThanOrEqualTo(String value) {
            addCriterion("desc_ >=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThan(String value) {
            addCriterion("desc_ <", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThanOrEqualTo(String value) {
            addCriterion("desc_ <=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLike(String value) {
            addCriterion("desc_ like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotLike(String value) {
            addCriterion("desc_ not like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescIn(List<String> values) {
            addCriterion("desc_ in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotIn(List<String> values) {
            addCriterion("desc_ not in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescBetween(String value1, String value2) {
            addCriterion("desc_ between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotBetween(String value1, String value2) {
            addCriterion("desc_ not between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code_ is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code_ is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code_ =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code_ <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code_ >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code_ >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code_ <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code_ <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code_ like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code_ not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code_ in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code_ not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code_ between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code_ not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(Integer value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(Integer value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(Integer value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(Integer value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(Integer value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<Integer> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<Integer> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(Integer value1, Integer value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(Integer value1, Integer value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andAppTypeIsNull() {
            addCriterion("app_type is null");
            return (Criteria) this;
        }

        public Criteria andAppTypeIsNotNull() {
            addCriterion("app_type is not null");
            return (Criteria) this;
        }

        public Criteria andAppTypeEqualTo(Short value) {
            addCriterion("app_type =", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotEqualTo(Short value) {
            addCriterion("app_type <>", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThan(Short value) {
            addCriterion("app_type >", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("app_type >=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThan(Short value) {
            addCriterion("app_type <", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThanOrEqualTo(Short value) {
            addCriterion("app_type <=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeIn(List<Short> values) {
            addCriterion("app_type in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotIn(List<Short> values) {
            addCriterion("app_type not in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeBetween(Short value1, Short value2) {
            addCriterion("app_type between", value1, value2, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotBetween(Short value1, Short value2) {
            addCriterion("app_type not between", value1, value2, "appType");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type_ is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type_ is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type_ =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type_ <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type_ >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type_ >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type_ <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type_ <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type_ like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type_ not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type_ in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type_ not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type_ between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type_ not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andProviderIsNull() {
            addCriterion("provider_ is null");
            return (Criteria) this;
        }

        public Criteria andProviderIsNotNull() {
            addCriterion("provider_ is not null");
            return (Criteria) this;
        }

        public Criteria andProviderEqualTo(String value) {
            addCriterion("provider_ =", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotEqualTo(String value) {
            addCriterion("provider_ <>", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderGreaterThan(String value) {
            addCriterion("provider_ >", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderGreaterThanOrEqualTo(String value) {
            addCriterion("provider_ >=", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLessThan(String value) {
            addCriterion("provider_ <", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLessThanOrEqualTo(String value) {
            addCriterion("provider_ <=", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLike(String value) {
            addCriterion("provider_ like", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotLike(String value) {
            addCriterion("provider_ not like", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderIn(List<String> values) {
            addCriterion("provider_ in", values, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotIn(List<String> values) {
            addCriterion("provider_ not in", values, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderBetween(String value1, String value2) {
            addCriterion("provider_ between", value1, value2, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotBetween(String value1, String value2) {
            addCriterion("provider_ not between", value1, value2, "provider");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status_ is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status_ is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status_ =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status_ <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status_ >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status_ >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status_ <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status_ <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status_ in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status_ not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status_ between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status_ not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRandomStrIsNull() {
            addCriterion("random_str is null");
            return (Criteria) this;
        }

        public Criteria andRandomStrIsNotNull() {
            addCriterion("random_str is not null");
            return (Criteria) this;
        }

        public Criteria andRandomStrEqualTo(String value) {
            addCriterion("random_str =", value, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrNotEqualTo(String value) {
            addCriterion("random_str <>", value, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrGreaterThan(String value) {
            addCriterion("random_str >", value, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrGreaterThanOrEqualTo(String value) {
            addCriterion("random_str >=", value, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrLessThan(String value) {
            addCriterion("random_str <", value, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrLessThanOrEqualTo(String value) {
            addCriterion("random_str <=", value, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrLike(String value) {
            addCriterion("random_str like", value, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrNotLike(String value) {
            addCriterion("random_str not like", value, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrIn(List<String> values) {
            addCriterion("random_str in", values, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrNotIn(List<String> values) {
            addCriterion("random_str not in", values, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrBetween(String value1, String value2) {
            addCriterion("random_str between", value1, value2, "randomStr");
            return (Criteria) this;
        }

        public Criteria andRandomStrNotBetween(String value1, String value2) {
            addCriterion("random_str not between", value1, value2, "randomStr");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(Long value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Long value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Long value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Long value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Long value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<Long> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<Long> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Long value1, Long value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Long value1, Long value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
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

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(Long value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(Long value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(Long value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(Long value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(Long value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<Long> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<Long> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(Long value1, Long value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(Long value1, Long value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
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

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("org_id like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("org_id not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeIsNull() {
            addCriterion("org_system_code is null");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeIsNotNull() {
            addCriterion("org_system_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeEqualTo(String value) {
            addCriterion("org_system_code =", value, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeNotEqualTo(String value) {
            addCriterion("org_system_code <>", value, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeGreaterThan(String value) {
            addCriterion("org_system_code >", value, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("org_system_code >=", value, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeLessThan(String value) {
            addCriterion("org_system_code <", value, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeLessThanOrEqualTo(String value) {
            addCriterion("org_system_code <=", value, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeLike(String value) {
            addCriterion("org_system_code like", value, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeNotLike(String value) {
            addCriterion("org_system_code not like", value, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeIn(List<String> values) {
            addCriterion("org_system_code in", values, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeNotIn(List<String> values) {
            addCriterion("org_system_code not in", values, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeBetween(String value1, String value2) {
            addCriterion("org_system_code between", value1, value2, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgSystemCodeNotBetween(String value1, String value2) {
            addCriterion("org_system_code not between", value1, value2, "orgSystemCode");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNull() {
            addCriterion("org_name is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("org_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("org_name =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("org_name <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("org_name >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("org_name >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("org_name <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("org_name <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("org_name like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("org_name not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("org_name in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("org_name not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("org_name between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("org_name not between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andReduceTimeIsNull() {
            addCriterion("reduce_time is null");
            return (Criteria) this;
        }

        public Criteria andReduceTimeIsNotNull() {
            addCriterion("reduce_time is not null");
            return (Criteria) this;
        }

        public Criteria andReduceTimeEqualTo(Double value) {
            addCriterion("reduce_time =", value, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeNotEqualTo(Double value) {
            addCriterion("reduce_time <>", value, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeGreaterThan(Double value) {
            addCriterion("reduce_time >", value, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("reduce_time >=", value, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeLessThan(Double value) {
            addCriterion("reduce_time <", value, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeLessThanOrEqualTo(Double value) {
            addCriterion("reduce_time <=", value, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeIn(List<Double> values) {
            addCriterion("reduce_time in", values, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeNotIn(List<Double> values) {
            addCriterion("reduce_time not in", values, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeBetween(Double value1, Double value2) {
            addCriterion("reduce_time between", value1, value2, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceTimeNotBetween(Double value1, Double value2) {
            addCriterion("reduce_time not between", value1, value2, "reduceTime");
            return (Criteria) this;
        }

        public Criteria andReduceCostIsNull() {
            addCriterion("reduce_cost is null");
            return (Criteria) this;
        }

        public Criteria andReduceCostIsNotNull() {
            addCriterion("reduce_cost is not null");
            return (Criteria) this;
        }

        public Criteria andReduceCostEqualTo(Integer value) {
            addCriterion("reduce_cost =", value, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostNotEqualTo(Integer value) {
            addCriterion("reduce_cost <>", value, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostGreaterThan(Integer value) {
            addCriterion("reduce_cost >", value, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostGreaterThanOrEqualTo(Integer value) {
            addCriterion("reduce_cost >=", value, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostLessThan(Integer value) {
            addCriterion("reduce_cost <", value, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostLessThanOrEqualTo(Integer value) {
            addCriterion("reduce_cost <=", value, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostIn(List<Integer> values) {
            addCriterion("reduce_cost in", values, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostNotIn(List<Integer> values) {
            addCriterion("reduce_cost not in", values, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostBetween(Integer value1, Integer value2) {
            addCriterion("reduce_cost between", value1, value2, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andReduceCostNotBetween(Integer value1, Integer value2) {
            addCriterion("reduce_cost not between", value1, value2, "reduceCost");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeIsNull() {
            addCriterion("original_time is null");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeIsNotNull() {
            addCriterion("original_time is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeEqualTo(Double value) {
            addCriterion("original_time =", value, "originalTime");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeNotEqualTo(Double value) {
            addCriterion("original_time <>", value, "originalTime");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeGreaterThan(Double value) {
            addCriterion("original_time >", value, "originalTime");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("original_time >=", value, "originalTime");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeLessThan(Double value) {
            addCriterion("original_time <", value, "originalTime");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeLessThanOrEqualTo(Double value) {
            addCriterion("original_time <=", value, "originalTime");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeIn(List<Double> values) {
            addCriterion("original_time in", values, "originalTime");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeNotIn(List<Double> values) {
            addCriterion("original_time not in", values, "originalTime");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeBetween(Double value1, Double value2) {
            addCriterion("original_time between", value1, value2, "originalTime");
            return (Criteria) this;
        }

        public Criteria andOriginalTimeNotBetween(Double value1, Double value2) {
            addCriterion("original_time not between", value1, value2, "originalTime");
            return (Criteria) this;
        }

        public Criteria andOriginalCostIsNull() {
            addCriterion("original_cost is null");
            return (Criteria) this;
        }

        public Criteria andOriginalCostIsNotNull() {
            addCriterion("original_cost is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalCostEqualTo(Integer value) {
            addCriterion("original_cost =", value, "originalCost");
            return (Criteria) this;
        }

        public Criteria andOriginalCostNotEqualTo(Integer value) {
            addCriterion("original_cost <>", value, "originalCost");
            return (Criteria) this;
        }

        public Criteria andOriginalCostGreaterThan(Integer value) {
            addCriterion("original_cost >", value, "originalCost");
            return (Criteria) this;
        }

        public Criteria andOriginalCostGreaterThanOrEqualTo(Integer value) {
            addCriterion("original_cost >=", value, "originalCost");
            return (Criteria) this;
        }

        public Criteria andOriginalCostLessThan(Integer value) {
            addCriterion("original_cost <", value, "originalCost");
            return (Criteria) this;
        }

        public Criteria andOriginalCostLessThanOrEqualTo(Integer value) {
            addCriterion("original_cost <=", value, "originalCost");
            return (Criteria) this;
        }

        public Criteria andOriginalCostIn(List<Integer> values) {
            addCriterion("original_cost in", values, "originalCost");
            return (Criteria) this;
        }

        public Criteria andOriginalCostNotIn(List<Integer> values) {
            addCriterion("original_cost not in", values, "originalCost");
            return (Criteria) this;
        }

        public Criteria andOriginalCostBetween(Integer value1, Integer value2) {
            addCriterion("original_cost between", value1, value2, "originalCost");
            return (Criteria) this;
        }

        public Criteria andOriginalCostNotBetween(Integer value1, Integer value2) {
            addCriterion("original_cost not between", value1, value2, "originalCost");
            return (Criteria) this;
        }

        public Criteria andIsFastAppIsNull() {
            addCriterion("is_fast_app is null");
            return (Criteria) this;
        }

        public Criteria andIsFastAppIsNotNull() {
            addCriterion("is_fast_app is not null");
            return (Criteria) this;
        }

        public Criteria andIsFastAppEqualTo(String value) {
            addCriterion("is_fast_app =", value, "isFastApp");
            return (Criteria) this;
        }

        public Criteria andIsFastAppNotEqualTo(String value) {
            addCriterion("is_fast_app <>", value, "isFastApp");
            return (Criteria) this;
        }

        public Criteria andIsFastAppGreaterThan(String value) {
            addCriterion("is_fast_app >", value, "isFastApp");
            return (Criteria) this;
        }

        public Criteria andIsFastAppGreaterThanOrEqualTo(String value) {
            addCriterion("is_fast_app >=", value, "isFastApp");
            return (Criteria) this;
        }

        public Criteria andIsFastAppLessThan(String value) {
            addCriterion("is_fast_app <", value, "isFastApp");
            return (Criteria) this;
        }

        public Criteria andIsFastAppLessThanOrEqualTo(String value) {
            addCriterion("is_fast_app <=", value, "isFastApp");
            return (Criteria) this;
        }

        public Criteria andIsFastAppLike(String value) {
            addCriterion("is_fast_app like", value, "isFastApp");
            return (Criteria) this;
        }

        public Criteria andIsFastAppNotLike(String value) {
            addCriterion("is_fast_app not like", value, "isFastApp");
            return (Criteria) this;
        }

        public Criteria andIsFastAppIn(List<String> values) {
            addCriterion("is_fast_app in", values, "isFastApp");
            return (Criteria) this;
        }

        public Criteria andIsFastAppNotIn(List<String> values) {
            addCriterion("is_fast_app not in", values, "isFastApp");
            return (Criteria) this;
        }

        public Criteria andIsFastAppBetween(String value1, String value2) {
            addCriterion("is_fast_app between", value1, value2, "isFastApp");
            return (Criteria) this;
        }

        public Criteria andIsFastAppNotBetween(String value1, String value2) {
            addCriterion("is_fast_app not between", value1, value2, "isFastApp");
            return (Criteria) this;
        }

        public Criteria andBizConfigIdIsNull() {
            addCriterion("biz_config_id is null");
            return (Criteria) this;
        }

        public Criteria andBizConfigIdIsNotNull() {
            addCriterion("biz_config_id is not null");
            return (Criteria) this;
        }

        public Criteria andBizConfigIdEqualTo(Long value) {
            addCriterion("biz_config_id =", value, "bizConfigId");
            return (Criteria) this;
        }

        public Criteria andBizConfigIdNotEqualTo(Long value) {
            addCriterion("biz_config_id <>", value, "bizConfigId");
            return (Criteria) this;
        }

        public Criteria andBizConfigIdGreaterThan(Long value) {
            addCriterion("biz_config_id >", value, "bizConfigId");
            return (Criteria) this;
        }

        public Criteria andBizConfigIdGreaterThanOrEqualTo(Long value) {
            addCriterion("biz_config_id >=", value, "bizConfigId");
            return (Criteria) this;
        }

        public Criteria andBizConfigIdLessThan(Long value) {
            addCriterion("biz_config_id <", value, "bizConfigId");
            return (Criteria) this;
        }

        public Criteria andBizConfigIdLessThanOrEqualTo(Long value) {
            addCriterion("biz_config_id <=", value, "bizConfigId");
            return (Criteria) this;
        }

        public Criteria andBizConfigIdIn(List<Long> values) {
            addCriterion("biz_config_id in", values, "bizConfigId");
            return (Criteria) this;
        }

        public Criteria andBizConfigIdNotIn(List<Long> values) {
            addCriterion("biz_config_id not in", values, "bizConfigId");
            return (Criteria) this;
        }

        public Criteria andBizConfigIdBetween(Long value1, Long value2) {
            addCriterion("biz_config_id between", value1, value2, "bizConfigId");
            return (Criteria) this;
        }

        public Criteria andBizConfigIdNotBetween(Long value1, Long value2) {
            addCriterion("biz_config_id not between", value1, value2, "bizConfigId");
            return (Criteria) this;
        }

        public Criteria andHotsCountIsNull() {
            addCriterion("hots_count is null");
            return (Criteria) this;
        }

        public Criteria andHotsCountIsNotNull() {
            addCriterion("hots_count is not null");
            return (Criteria) this;
        }

        public Criteria andHotsCountEqualTo(Integer value) {
            addCriterion("hots_count =", value, "hotsCount");
            return (Criteria) this;
        }

        public Criteria andHotsCountNotEqualTo(Integer value) {
            addCriterion("hots_count <>", value, "hotsCount");
            return (Criteria) this;
        }

        public Criteria andHotsCountGreaterThan(Integer value) {
            addCriterion("hots_count >", value, "hotsCount");
            return (Criteria) this;
        }

        public Criteria andHotsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("hots_count >=", value, "hotsCount");
            return (Criteria) this;
        }

        public Criteria andHotsCountLessThan(Integer value) {
            addCriterion("hots_count <", value, "hotsCount");
            return (Criteria) this;
        }

        public Criteria andHotsCountLessThanOrEqualTo(Integer value) {
            addCriterion("hots_count <=", value, "hotsCount");
            return (Criteria) this;
        }

        public Criteria andHotsCountIn(List<Integer> values) {
            addCriterion("hots_count in", values, "hotsCount");
            return (Criteria) this;
        }

        public Criteria andHotsCountNotIn(List<Integer> values) {
            addCriterion("hots_count not in", values, "hotsCount");
            return (Criteria) this;
        }

        public Criteria andHotsCountBetween(Integer value1, Integer value2) {
            addCriterion("hots_count between", value1, value2, "hotsCount");
            return (Criteria) this;
        }

        public Criteria andHotsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("hots_count not between", value1, value2, "hotsCount");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostIsNull() {
            addCriterion("reduce_build_cost is null");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostIsNotNull() {
            addCriterion("reduce_build_cost is not null");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostEqualTo(Integer value) {
            addCriterion("reduce_build_cost =", value, "reduceBuildCost");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostNotEqualTo(Integer value) {
            addCriterion("reduce_build_cost <>", value, "reduceBuildCost");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostGreaterThan(Integer value) {
            addCriterion("reduce_build_cost >", value, "reduceBuildCost");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostGreaterThanOrEqualTo(Integer value) {
            addCriterion("reduce_build_cost >=", value, "reduceBuildCost");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostLessThan(Integer value) {
            addCriterion("reduce_build_cost <", value, "reduceBuildCost");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostLessThanOrEqualTo(Integer value) {
            addCriterion("reduce_build_cost <=", value, "reduceBuildCost");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostIn(List<Integer> values) {
            addCriterion("reduce_build_cost in", values, "reduceBuildCost");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostNotIn(List<Integer> values) {
            addCriterion("reduce_build_cost not in", values, "reduceBuildCost");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostBetween(Integer value1, Integer value2) {
            addCriterion("reduce_build_cost between", value1, value2, "reduceBuildCost");
            return (Criteria) this;
        }

        public Criteria andReduceBuildCostNotBetween(Integer value1, Integer value2) {
            addCriterion("reduce_build_cost not between", value1, value2, "reduceBuildCost");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostIsNull() {
            addCriterion("reduce_use_cost is null");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostIsNotNull() {
            addCriterion("reduce_use_cost is not null");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostEqualTo(Integer value) {
            addCriterion("reduce_use_cost =", value, "reduceUseCost");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostNotEqualTo(Integer value) {
            addCriterion("reduce_use_cost <>", value, "reduceUseCost");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostGreaterThan(Integer value) {
            addCriterion("reduce_use_cost >", value, "reduceUseCost");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostGreaterThanOrEqualTo(Integer value) {
            addCriterion("reduce_use_cost >=", value, "reduceUseCost");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostLessThan(Integer value) {
            addCriterion("reduce_use_cost <", value, "reduceUseCost");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostLessThanOrEqualTo(Integer value) {
            addCriterion("reduce_use_cost <=", value, "reduceUseCost");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostIn(List<Integer> values) {
            addCriterion("reduce_use_cost in", values, "reduceUseCost");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostNotIn(List<Integer> values) {
            addCriterion("reduce_use_cost not in", values, "reduceUseCost");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostBetween(Integer value1, Integer value2) {
            addCriterion("reduce_use_cost between", value1, value2, "reduceUseCost");
            return (Criteria) this;
        }

        public Criteria andReduceUseCostNotBetween(Integer value1, Integer value2) {
            addCriterion("reduce_use_cost not between", value1, value2, "reduceUseCost");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostIsNull() {
            addCriterion("reduce_protect_cost is null");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostIsNotNull() {
            addCriterion("reduce_protect_cost is not null");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostEqualTo(Integer value) {
            addCriterion("reduce_protect_cost =", value, "reduceProtectCost");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostNotEqualTo(Integer value) {
            addCriterion("reduce_protect_cost <>", value, "reduceProtectCost");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostGreaterThan(Integer value) {
            addCriterion("reduce_protect_cost >", value, "reduceProtectCost");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostGreaterThanOrEqualTo(Integer value) {
            addCriterion("reduce_protect_cost >=", value, "reduceProtectCost");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostLessThan(Integer value) {
            addCriterion("reduce_protect_cost <", value, "reduceProtectCost");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostLessThanOrEqualTo(Integer value) {
            addCriterion("reduce_protect_cost <=", value, "reduceProtectCost");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostIn(List<Integer> values) {
            addCriterion("reduce_protect_cost in", values, "reduceProtectCost");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostNotIn(List<Integer> values) {
            addCriterion("reduce_protect_cost not in", values, "reduceProtectCost");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostBetween(Integer value1, Integer value2) {
            addCriterion("reduce_protect_cost between", value1, value2, "reduceProtectCost");
            return (Criteria) this;
        }

        public Criteria andReduceProtectCostNotBetween(Integer value1, Integer value2) {
            addCriterion("reduce_protect_cost not between", value1, value2, "reduceProtectCost");
            return (Criteria) this;
        }

        public Criteria andPublicIsIsNull() {
            addCriterion("public_is is null");
            return (Criteria) this;
        }

        public Criteria andPublicIsIsNotNull() {
            addCriterion("public_is is not null");
            return (Criteria) this;
        }

        public Criteria andPublicIsEqualTo(Boolean value) {
            addCriterion("public_is =", value, "publicIs");
            return (Criteria) this;
        }

        public Criteria andPublicIsNotEqualTo(Boolean value) {
            addCriterion("public_is <>", value, "publicIs");
            return (Criteria) this;
        }

        public Criteria andPublicIsGreaterThan(Boolean value) {
            addCriterion("public_is >", value, "publicIs");
            return (Criteria) this;
        }

        public Criteria andPublicIsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("public_is >=", value, "publicIs");
            return (Criteria) this;
        }

        public Criteria andPublicIsLessThan(Boolean value) {
            addCriterion("public_is <", value, "publicIs");
            return (Criteria) this;
        }

        public Criteria andPublicIsLessThanOrEqualTo(Boolean value) {
            addCriterion("public_is <=", value, "publicIs");
            return (Criteria) this;
        }

        public Criteria andPublicIsIn(List<Boolean> values) {
            addCriterion("public_is in", values, "publicIs");
            return (Criteria) this;
        }

        public Criteria andPublicIsNotIn(List<Boolean> values) {
            addCriterion("public_is not in", values, "publicIs");
            return (Criteria) this;
        }

        public Criteria andPublicIsBetween(Boolean value1, Boolean value2) {
            addCriterion("public_is between", value1, value2, "publicIs");
            return (Criteria) this;
        }

        public Criteria andPublicIsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("public_is not between", value1, value2, "publicIs");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNull() {
            addCriterion("service_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNotNull() {
            addCriterion("service_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIdEqualTo(String value) {
            addCriterion("service_id =", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotEqualTo(String value) {
            addCriterion("service_id <>", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThan(String value) {
            addCriterion("service_id >", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(String value) {
            addCriterion("service_id >=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThan(String value) {
            addCriterion("service_id <", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThanOrEqualTo(String value) {
            addCriterion("service_id <=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLike(String value) {
            addCriterion("service_id like", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotLike(String value) {
            addCriterion("service_id not like", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIn(List<String> values) {
            addCriterion("service_id in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotIn(List<String> values) {
            addCriterion("service_id not in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdBetween(String value1, String value2) {
            addCriterion("service_id between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotBetween(String value1, String value2) {
            addCriterion("service_id not between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andFullRootPathIsNull() {
            addCriterion("full_root_path is null");
            return (Criteria) this;
        }

        public Criteria andFullRootPathIsNotNull() {
            addCriterion("full_root_path is not null");
            return (Criteria) this;
        }

        public Criteria andFullRootPathEqualTo(String value) {
            addCriterion("full_root_path =", value, "fullRootPath");
            return (Criteria) this;
        }

        public Criteria andFullRootPathNotEqualTo(String value) {
            addCriterion("full_root_path <>", value, "fullRootPath");
            return (Criteria) this;
        }

        public Criteria andFullRootPathGreaterThan(String value) {
            addCriterion("full_root_path >", value, "fullRootPath");
            return (Criteria) this;
        }

        public Criteria andFullRootPathGreaterThanOrEqualTo(String value) {
            addCriterion("full_root_path >=", value, "fullRootPath");
            return (Criteria) this;
        }

        public Criteria andFullRootPathLessThan(String value) {
            addCriterion("full_root_path <", value, "fullRootPath");
            return (Criteria) this;
        }

        public Criteria andFullRootPathLessThanOrEqualTo(String value) {
            addCriterion("full_root_path <=", value, "fullRootPath");
            return (Criteria) this;
        }

        public Criteria andFullRootPathLike(String value) {
            addCriterion("full_root_path like", value, "fullRootPath");
            return (Criteria) this;
        }

        public Criteria andFullRootPathNotLike(String value) {
            addCriterion("full_root_path not like", value, "fullRootPath");
            return (Criteria) this;
        }

        public Criteria andFullRootPathIn(List<String> values) {
            addCriterion("full_root_path in", values, "fullRootPath");
            return (Criteria) this;
        }

        public Criteria andFullRootPathNotIn(List<String> values) {
            addCriterion("full_root_path not in", values, "fullRootPath");
            return (Criteria) this;
        }

        public Criteria andFullRootPathBetween(String value1, String value2) {
            addCriterion("full_root_path between", value1, value2, "fullRootPath");
            return (Criteria) this;
        }

        public Criteria andFullRootPathNotBetween(String value1, String value2) {
            addCriterion("full_root_path not between", value1, value2, "fullRootPath");
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