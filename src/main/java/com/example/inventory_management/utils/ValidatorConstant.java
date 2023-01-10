package com.example.inventory_management.utils;

public class ValidatorConstant {

    /* USER VALIDATOR CONSTANTS */
    public static final String REQUIRED_USER_FIRSTNAME    = "FirstName field is required";
    public static final String REQUIRED_USER_LASTNAME    = "LastName field is required";
    public static final String REQUIRED_USER_MAIL    = "Mail field is required";
    public static final String REQUIRED_USER_PASSWORD    = "Password field is required";
    public static final String REQUIRED_USER_ADDRESS = "Address field is required";

    /* ADDRESS VALIDATOR CONSTANTS */
    public static final String REQUIRED_ADDRESS_COUNTRY    = "Country field is required";
    public static final String REQUIRED_ADDRESS_CITY    = "City field is required";
    public static final String REQUIRED_ADDRESS_ADDRESS1    = "Address field is required";
    public static final String REQUIRED_ADDRESS_ZIPCODE    = "ZipCode field is required";

    /* CATEGORY VALIDATOR CONSTANTS */
    public static final String REQUIRED_CATEGORY_CODE    = "Category code field is required";

    /* ITEM VALIDATOR CONSTANTS */
    public static final String REQUIRED_ITEM_CODE    = "Code field is required";
    public static final String REQUIRED_ITEM_DESIGNATION    = "Designation field is required";
    public static final String REQUIRED_ITEM_PRICE_HT    = "Price HT field is required";
    public static final String ITEM_PRICE_HT_NEGATIVE = "Price HT field cannot be negative";
    public static final String REQUIRED_ITEM_TVA    = "Tva field is required";
    public static final String ITEM_TVA_NEGATIVE = "Tva field is required";
    public static final String REQUIRED_ITEM_CATEGORY    = "Category field is required";

    /* COMPANY VALIDATOR CONSTANTS */
    public static final String REQUIRED_COMPANY_NAME   = "Company name field is required";
    public static final String REQUIRED_COMPANY_TEL    = "Company phone field is required";
    public static final String REQUIRED_COMPANY_ADDRESS  = "Company address field is required";
    public static final String REQUIRED_COMPANY_MAIL    = "Company mail field cannot be negative";

    /* ORDER VALIDATOR CONSTANTS */
    public static final String REQUIRED_ORDER_CODE   = "Order code field is required";
    public static final String REQUIRED_ORDER_CLIENT   = "Order client field is required";
    public static final String REQUIRED_ORDER_DETAILS   = "Order details is required";
    public static final String REQUIRED_ORDER_SUPPLIER   = "Order supplier field is required";

    /* LINE ORDER VALIDATOR CONSTANTS */
    public static final String REQUIRED_LINE_ORDER_ITEM   = "Line order item field is required";
    public static final String REQUIRED_LINE_ORDER_QTE   = "Line order quantity field is required";
    public static final String REQUIRED_LINE_ORDER_UNITE_PRICE   = "Order unite price field is required";

}
