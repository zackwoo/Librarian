package com.github.librarian.model.entity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BookExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BOOK
     *
     * @mbg.generated Mon May 01 16:23:46 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BOOK
     *
     * @mbg.generated Mon May 01 16:23:46 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BOOK
     *
     * @mbg.generated Mon May 01 16:23:46 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BOOK
     *
     * @mbg.generated Mon May 01 16:23:46 CST 2017
     */
    public BookExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BOOK
     *
     * @mbg.generated Mon May 01 16:23:46 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BOOK
     *
     * @mbg.generated Mon May 01 16:23:46 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BOOK
     *
     * @mbg.generated Mon May 01 16:23:46 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BOOK
     *
     * @mbg.generated Mon May 01 16:23:46 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BOOK
     *
     * @mbg.generated Mon May 01 16:23:46 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BOOK
     *
     * @mbg.generated Mon May 01 16:23:46 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BOOK
     *
     * @mbg.generated Mon May 01 16:23:46 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BOOK
     *
     * @mbg.generated Mon May 01 16:23:46 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BOOK
     *
     * @mbg.generated Mon May 01 16:23:46 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BOOK
     *
     * @mbg.generated Mon May 01 16:23:46 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table BOOK
     *
     * @mbg.generated Mon May 01 16:23:46 CST 2017
     */
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

        public Criteria andIsbnIsNull() {
            addCriterion("ISBN is null");
            return (Criteria) this;
        }

        public Criteria andIsbnIsNotNull() {
            addCriterion("ISBN is not null");
            return (Criteria) this;
        }

        public Criteria andIsbnEqualTo(String value) {
            addCriterion("ISBN =", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotEqualTo(String value) {
            addCriterion("ISBN <>", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnGreaterThan(String value) {
            addCriterion("ISBN >", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnGreaterThanOrEqualTo(String value) {
            addCriterion("ISBN >=", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLessThan(String value) {
            addCriterion("ISBN <", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLessThanOrEqualTo(String value) {
            addCriterion("ISBN <=", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLike(String value) {
            addCriterion("ISBN like", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotLike(String value) {
            addCriterion("ISBN not like", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnIn(List<String> values) {
            addCriterion("ISBN in", values, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotIn(List<String> values) {
            addCriterion("ISBN not in", values, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnBetween(String value1, String value2) {
            addCriterion("ISBN between", value1, value2, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotBetween(String value1, String value2) {
            addCriterion("ISBN not between", value1, value2, "isbn");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andIntroIsNull() {
            addCriterion("INTRO is null");
            return (Criteria) this;
        }

        public Criteria andIntroIsNotNull() {
            addCriterion("INTRO is not null");
            return (Criteria) this;
        }

        public Criteria andIntroEqualTo(String value) {
            addCriterion("INTRO =", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotEqualTo(String value) {
            addCriterion("INTRO <>", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroGreaterThan(String value) {
            addCriterion("INTRO >", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroGreaterThanOrEqualTo(String value) {
            addCriterion("INTRO >=", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLessThan(String value) {
            addCriterion("INTRO <", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLessThanOrEqualTo(String value) {
            addCriterion("INTRO <=", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLike(String value) {
            addCriterion("INTRO like", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotLike(String value) {
            addCriterion("INTRO not like", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroIn(List<String> values) {
            addCriterion("INTRO in", values, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotIn(List<String> values) {
            addCriterion("INTRO not in", values, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroBetween(String value1, String value2) {
            addCriterion("INTRO between", value1, value2, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotBetween(String value1, String value2) {
            addCriterion("INTRO not between", value1, value2, "intro");
            return (Criteria) this;
        }

        public Criteria andBookcountIsNull() {
            addCriterion("BOOKCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andBookcountIsNotNull() {
            addCriterion("BOOKCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBookcountEqualTo(Integer value) {
            addCriterion("BOOKCOUNT =", value, "bookcount");
            return (Criteria) this;
        }

        public Criteria andBookcountNotEqualTo(Integer value) {
            addCriterion("BOOKCOUNT <>", value, "bookcount");
            return (Criteria) this;
        }

        public Criteria andBookcountGreaterThan(Integer value) {
            addCriterion("BOOKCOUNT >", value, "bookcount");
            return (Criteria) this;
        }

        public Criteria andBookcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("BOOKCOUNT >=", value, "bookcount");
            return (Criteria) this;
        }

        public Criteria andBookcountLessThan(Integer value) {
            addCriterion("BOOKCOUNT <", value, "bookcount");
            return (Criteria) this;
        }

        public Criteria andBookcountLessThanOrEqualTo(Integer value) {
            addCriterion("BOOKCOUNT <=", value, "bookcount");
            return (Criteria) this;
        }

        public Criteria andBookcountIn(List<Integer> values) {
            addCriterion("BOOKCOUNT in", values, "bookcount");
            return (Criteria) this;
        }

        public Criteria andBookcountNotIn(List<Integer> values) {
            addCriterion("BOOKCOUNT not in", values, "bookcount");
            return (Criteria) this;
        }

        public Criteria andBookcountBetween(Integer value1, Integer value2) {
            addCriterion("BOOKCOUNT between", value1, value2, "bookcount");
            return (Criteria) this;
        }

        public Criteria andBookcountNotBetween(Integer value1, Integer value2) {
            addCriterion("BOOKCOUNT not between", value1, value2, "bookcount");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table BOOK
     *
     * @mbg.generated do_not_delete_during_merge Mon May 01 16:23:46 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table BOOK
         *
         * @mbg.generated Mon May 01 16:23:46 CST 2017
         */
        public Criteria andMap(java.util.Map<String, Object> map) {
            if (map.containsKey("IsbnEqualTo")){
                 andIsbnEqualTo((String) map.get("IsbnEqualTo"));
            }
            if (map.containsKey("IsbnNotEqualTo")){
                 andIsbnNotEqualTo((String) map.get("IsbnNotEqualTo"));
            }
            if (map.containsKey("IsbnGreaterThan")){
                 andIsbnGreaterThan((String) map.get("IsbnGreaterThan"));
            }
            if (map.containsKey("IsbnGreaterThanOrEqualTo")){
                 andIsbnGreaterThanOrEqualTo((String) map.get("IsbnGreaterThanOrEqualTo"));
            }
            if (map.containsKey("IsbnLessThan")){
                 andIsbnLessThan((String) map.get("IsbnLessThan"));
            }
            if (map.containsKey("IsbnLessThanOrEqualTo")){
                 andIsbnLessThanOrEqualTo((String) map.get("IsbnLessThanOrEqualTo"));
            }
            if (map.containsKey("IsbnLike")){
                 andIsbnLike((String) map.get("IsbnLike"));
            }
            if (map.containsKey("IsbnNotLike")){
                 andIsbnNotLike((String) map.get("IsbnNotLike"));
            }
            if (map.containsKey("IsbnIn")){
                 andIsbnIn((List<String>) map.get("IsbnIn"));
            }
            if (map.containsKey("IsbnNotIn")){
                 andIsbnNotIn((List<String>) map.get("IsbnNotIn"));
            }
            if (map.containsKey("NameEqualTo")){
                 andNameEqualTo((String) map.get("NameEqualTo"));
            }
            if (map.containsKey("NameNotEqualTo")){
                 andNameNotEqualTo((String) map.get("NameNotEqualTo"));
            }
            if (map.containsKey("NameGreaterThan")){
                 andNameGreaterThan((String) map.get("NameGreaterThan"));
            }
            if (map.containsKey("NameGreaterThanOrEqualTo")){
                 andNameGreaterThanOrEqualTo((String) map.get("NameGreaterThanOrEqualTo"));
            }
            if (map.containsKey("NameLessThan")){
                 andNameLessThan((String) map.get("NameLessThan"));
            }
            if (map.containsKey("NameLessThanOrEqualTo")){
                 andNameLessThanOrEqualTo((String) map.get("NameLessThanOrEqualTo"));
            }
            if (map.containsKey("NameLike")){
                 andNameLike((String) map.get("NameLike"));
            }
            if (map.containsKey("NameNotLike")){
                 andNameNotLike((String) map.get("NameNotLike"));
            }
            if (map.containsKey("NameIn")){
                 andNameIn((List<String>) map.get("NameIn"));
            }
            if (map.containsKey("NameNotIn")){
                 andNameNotIn((List<String>) map.get("NameNotIn"));
            }
            if (map.containsKey("IntroEqualTo")){
                 andIntroEqualTo((String) map.get("IntroEqualTo"));
            }
            if (map.containsKey("IntroNotEqualTo")){
                 andIntroNotEqualTo((String) map.get("IntroNotEqualTo"));
            }
            if (map.containsKey("IntroGreaterThan")){
                 andIntroGreaterThan((String) map.get("IntroGreaterThan"));
            }
            if (map.containsKey("IntroGreaterThanOrEqualTo")){
                 andIntroGreaterThanOrEqualTo((String) map.get("IntroGreaterThanOrEqualTo"));
            }
            if (map.containsKey("IntroLessThan")){
                 andIntroLessThan((String) map.get("IntroLessThan"));
            }
            if (map.containsKey("IntroLessThanOrEqualTo")){
                 andIntroLessThanOrEqualTo((String) map.get("IntroLessThanOrEqualTo"));
            }
            if (map.containsKey("IntroLike")){
                 andIntroLike((String) map.get("IntroLike"));
            }
            if (map.containsKey("IntroNotLike")){
                 andIntroNotLike((String) map.get("IntroNotLike"));
            }
            if (map.containsKey("IntroIn")){
                 andIntroIn((List<String>) map.get("IntroIn"));
            }
            if (map.containsKey("IntroNotIn")){
                 andIntroNotIn((List<String>) map.get("IntroNotIn"));
            }
            if (map.containsKey("BookcountEqualTo")){
                 andBookcountEqualTo((Integer) map.get("BookcountEqualTo"));
            }
            if (map.containsKey("BookcountNotEqualTo")){
                 andBookcountNotEqualTo((Integer) map.get("BookcountNotEqualTo"));
            }
            if (map.containsKey("BookcountGreaterThan")){
                 andBookcountGreaterThan((Integer) map.get("BookcountGreaterThan"));
            }
            if (map.containsKey("BookcountGreaterThanOrEqualTo")){
                 andBookcountGreaterThanOrEqualTo((Integer) map.get("BookcountGreaterThanOrEqualTo"));
            }
            if (map.containsKey("BookcountLessThan")){
                 andBookcountLessThan((Integer) map.get("BookcountLessThan"));
            }
            if (map.containsKey("BookcountLessThanOrEqualTo")){
                 andBookcountLessThanOrEqualTo((Integer) map.get("BookcountLessThanOrEqualTo"));
            }
            if (map.containsKey("BookcountIn")){
                 andBookcountIn((List<Integer>) map.get("BookcountIn"));
            }
            if (map.containsKey("BookcountNotIn")){
                 andBookcountNotIn((List<Integer>) map.get("BookcountNotIn"));
            }
            return this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table BOOK
     *
     * @mbg.generated Mon May 01 16:23:46 CST 2017
     */
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