package system.dao;

import system.entity.SysDict;
import system.entity.SysDictExample;
import system.entity.SysDictExample.Criteria;
import system.entity.SysDictExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class SysDictSqlProvider {

    public String countByExample(SysDictExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_dict");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SysDictExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_dict");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SysDict record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_dict");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getItemCode() != null) {
            sql.VALUES("item_code", "#{itemCode,jdbcType=VARCHAR}");
        }
        
        if (record.getItemName() != null) {
            sql.VALUES("item_name", "#{itemName,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeCode() != null) {
            sql.VALUES("type_code", "#{typeCode,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeName() != null) {
            sql.VALUES("type_name", "#{typeName,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            sql.VALUES("sort", "#{sort,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateBy() != null) {
            sql.VALUES("create_by", "#{createBy,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            sql.VALUES("create_date", "#{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            sql.VALUES("update_by", "#{updateBy,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateDate() != null) {
            sql.VALUES("update_date", "#{updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemarks() != null) {
            sql.VALUES("remarks", "#{remarks,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SysDictExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("item_code");
        sql.SELECT("item_name");
        sql.SELECT("type_code");
        sql.SELECT("type_name");
        sql.SELECT("sort");
        sql.SELECT("create_by");
        sql.SELECT("create_date");
        sql.SELECT("update_by");
        sql.SELECT("update_date");
        sql.SELECT("remarks");
        sql.FROM("sys_dict");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysDict record = (SysDict) parameter.get("record");
        SysDictExample example = (SysDictExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_dict");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getItemCode() != null) {
            sql.SET("item_code = #{record.itemCode,jdbcType=VARCHAR}");
        }
        
        if (record.getItemName() != null) {
            sql.SET("item_name = #{record.itemName,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeCode() != null) {
            sql.SET("type_code = #{record.typeCode,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeName() != null) {
            sql.SET("type_name = #{record.typeName,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{record.sort,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateBy() != null) {
            sql.SET("create_by = #{record.createBy,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            sql.SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            sql.SET("update_by = #{record.updateBy,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateDate() != null) {
            sql.SET("update_date = #{record.updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemarks() != null) {
            sql.SET("remarks = #{record.remarks,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_dict");
        
        sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        sql.SET("item_code = #{record.itemCode,jdbcType=VARCHAR}");
        sql.SET("item_name = #{record.itemName,jdbcType=VARCHAR}");
        sql.SET("type_code = #{record.typeCode,jdbcType=VARCHAR}");
        sql.SET("type_name = #{record.typeName,jdbcType=VARCHAR}");
        sql.SET("sort = #{record.sort,jdbcType=DECIMAL}");
        sql.SET("create_by = #{record.createBy,jdbcType=VARCHAR}");
        sql.SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        sql.SET("update_by = #{record.updateBy,jdbcType=VARCHAR}");
        sql.SET("update_date = #{record.updateDate,jdbcType=TIMESTAMP}");
        sql.SET("remarks = #{record.remarks,jdbcType=VARCHAR}");
        
        SysDictExample example = (SysDictExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysDict record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_dict");
        
        if (record.getItemCode() != null) {
            sql.SET("item_code = #{itemCode,jdbcType=VARCHAR}");
        }
        
        if (record.getItemName() != null) {
            sql.SET("item_name = #{itemName,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeCode() != null) {
            sql.SET("type_code = #{typeCode,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeName() != null) {
            sql.SET("type_name = #{typeName,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{sort,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateBy() != null) {
            sql.SET("create_by = #{createBy,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            sql.SET("create_date = #{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            sql.SET("update_by = #{updateBy,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateDate() != null) {
            sql.SET("update_date = #{updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemarks() != null) {
            sql.SET("remarks = #{remarks,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SysDictExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}