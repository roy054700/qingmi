package com.qingmi.yi.common.utils;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.qingmi.yi.common.enums.SysDictEnum;

import java.lang.reflect.Field;

/**
 * @ClassNameCustomStringStringConverter
 * @Description
 * @Author 冷言丶冷语
 * @Date2019-10-21 18:20
 **/
public class CustomStringStringConverter implements Converter<String> {
    @Override
    public Class supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public String convertToJavaData(CellData cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return cellData.getStringValue();
    }

    @Override
    public CellData convertToExcelData(String value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        Field field = contentProperty.getField();
        String name = field.getName();
        String dataValue="";
        if(name.equals("cardType")){
            dataValue=SysDictEnum.getLabel("CARD_TYPE",value);
        }
        if(name.equals("cardLevel")){
            dataValue=SysDictEnum.getLabel("CARD_LEVEL",value);
        }
        if(name.equals("isRecharge")){
            dataValue=value.equals("1")?"是":"否";
        }
        if(name.equals("state")){
            dataValue=SysDictEnum.getLabel("CARD_INSTANCE_STATE",value);
        }
        return new CellData(dataValue);
    }
}
