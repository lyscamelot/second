package system.dao;

import system.entity.SysMenu;
import system.entity.SysMenuExample;
import system.entity.SysMenuExample.Criteria;
import system.entity.SysMenuExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class SysMenuSqlProvider {

    public String countByExample(SysMenuExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_menu");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SysMenuExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_menu");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SysMenu record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_menu");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            sql.VALUES("parent_id", "#{parentId,jdbcType=VARCHAR}");
        }
        
        if (record.getParentIds() != null) {
            sql.VALUES("parent_ids", "#{parentIds,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            sql.VALUES("sort", "#{sort,jdbcType=DECIMAL}");
        }
        
        if (record.getHref() != null) {
            sql.VALUES("href", "#{href,jdbcType=VARCHAR}");
        }
        
        if (record.getTarget() != null) {
            sql.VALUES("target", "#{target,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.VALUES("icon", "#{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getIsShow() != null) {
            sql.VALUES("is_show", "#{isShow,jdbcType=CHAR}");
        }
        
        if (record.getPermission() != null) {
            sql.VALUES("permission", "#{permission,jdbcType=VARCHAR}");
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

    public String selectByExample(SysMenuExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("parent_id");
        sql.SELECT("parent_ids");
        sql.SELECT("name");
        sql.SELECT("sort");
        sql.SELECT("href");
        sql.SELECT("target");
        sql.SELECT("icon");
        sql.SELECT("is_show");
        sql.SELECT("permission");
        sql.SELECT("create_by");
        sql.SELECT("create_date");
        sql.SELECT("update_by");
        sql.SELECT("update_date");
        sql.SELECT("remarks");
        sql.FROM("sys_menu");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysMenu record = (SysMenu) parameter.get("record");
        SysMenuExample example = (SysMenuExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_menu");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{record.parentId,jdbcType=VARCHAR}");
        }
        
        if (record.getParentIds() != null) {
            sql.SET("parent_ids = #{record.parentIds,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{record.sort,jdbcType=DECIMAL}");
        }
        
        if (record.getHref() != null) {
            sql.SET("href = #{record.href,jdbcType=VARCHAR}");
        }
        
        if (record.getTarget() != null) {
            sql.SET("target = #{record.target,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.SET("icon = #{record.icon,jdbcType=VARCHAR}");
        }
        
        if (record.getIsShow() != null) {
            sql.SET("is_show = #{record.isShow,jdbcType=CHAR}");
        }
        
        if (record.getPermission() != null) {
            sql.SET("permission = #{record.permission,jdbcType=VARCHAR}");
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
        sql.UPDATE("sys_menu");
        
        sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        sql.SET("parent_id = #{record.parentId,jdbcType=VARCHAR}");
        sql.SET("parent_ids = #{record.parentIds,jdbcType=VARCHAR}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("sort = #{record.sort,jdbcType=DECIMAL}");
        sql.SET("href = #{record.href,jdbcType=VARCHAR}");
        sql.SET("target = #{record.target,jdbcType=VARCHAR}");
        sql.SET("icon = #{record.icon,jdbcType=VARCHAR}");
        sql.SET("is_show = #{record.isShow,jdbcType=CHAR}");
        sql.SET("permission = #{record.permission,jdbcType=VARCHAR}");
        sql.SET("create_by = #{record.createBy,jdbcType=VARCHAR}");
        sql.SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        sql.SET("update_by = #{record.updateBy,jdbcType=VARCHAR}");
        sql.SET("update_date = #{record.updateDate,jdbcType=TIMESTAMP}");
        sql.SET("remarks = #{record.remarks,jdbcType=VARCHAR}");
        
        SysMenuExample example = (SysMenuExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysMenu record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_menu");
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{parentId,jdbcType=VARCHAR}");
        }
        
        if (record.getParentIds() != null) {
            sql.SET("parent_ids = #{parentIds,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            sql.SET("sort = #{sort,jdbcType=DECIMAL}");
        }
        
        if (record.getHref() != null) {
            sql.SET("href = #{href,jdbcType=VARCHAR}");
        }
        
        if (record.getTarget() != null) {
            sql.SET("target = #{target,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.SET("icon = #{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getIsShow() != null) {
            sql.SET("is_show = #{isShow,jdbcType=CHAR}");
        }
        
        if (record.getPermission() != null) {
            sql.SET("permission = #{permission,jdbcType=VARCHAR}");
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

    protected void applyWhere(SQL sql, SysMenuExample example, boolean includeExamplePhrase) {
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