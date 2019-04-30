package com.drebander.excel.util;

import com.drebander.excel.domain.SjtyExcelDto;
import com.drebander.excel.domain.SjtyExcelVO;
import org.springframework.beans.BeanUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.Date;

public class VOUtil<S, D> {

    public static void copy(Object source, Object dest) {
        VOUtil v = new VOUtil();
        v._copy(source, dest);
    }

    public static Object generate(Object source, Class destClass) {
        VOUtil v = new VOUtil();
        return v._generate(source, destClass);
    }
//     ********************************unit test*******************************************

    /**
     * unit test for this tool!
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) {
        SjtyExcelDto dto = new SjtyExcelDto();
        dto.setAddr("Beijing");
        dto.setAge("18");
        dto.setName("Drebander");
        dto.setSky("blue");
        dto.setDate(new Date());
        SjtyExcelVO vo = new SjtyExcelVO();
        copy(dto, vo);
        SjtyExcelVO vo2 = (SjtyExcelVO) generate(dto, SjtyExcelVO.class);
        System.out.println("vo---->" + vo.toString());
        System.out.println("vo2--->" + vo2.toString());
        SjtyExcelVO vo3 = new SjtyExcelVO();
        BeanUtils.copyProperties(dto, vo3);
        System.out.println("vo3--->" + vo3.toString());
        BeanUtils.copyProperties(dto,vo3);
    }

//     *******************************private method***************************************

    /**
     * Copy from source object to dest object to the same attributes
     *
     * @param source
     * @param dest
     * @throws Exception
     */
    void _copy(S source, D dest) {

        try {
            BeanInfo destBean = Introspector.getBeanInfo(dest.getClass(), java.lang.Object.class);
            PropertyDescriptor[] destProperty = destBean.getPropertyDescriptors();
            for (int i = 0; i < destProperty.length; i++) {
                String fieldName = destProperty[i].getName();
                try {
                    Field field = source.getClass().getField(fieldName);
                    if (field != null) {
                        destProperty[i].getWriteMethod().invoke(dest, field.get(source));
                    }
                } catch (Exception e) {
                    //  当找不到字段的时候，不做处理
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Generate a new Object by the source object that have the same attribute with the dest object
     *
     * @param source
     * @param destClass
     * @return
     */
    D _generate(S source, Class<D> destClass) {
        try {
            D dest = destClass.newInstance();
            _copy(source, dest);
            return dest;
        } catch (Exception e) {
            return null;
        }

    }
}
