package system.dao;

import system.entity.SysDept;
import system.entity.SysDeptExample;
import system.entity.SysDeptExample.Criteria;
import system.entity.SysDeptExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class SysDeptSqlProvider {

    public String countByExample(SysDeptExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_dept");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SysDeptExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_dept");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SysDept record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_dept");
        
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
        
        if (record.getRegisteredCapital() != null) {
            sql.VALUES("registered_capital", "#{registeredCapital,jdbcType=VARCHAR}");
        }
        
        if (record.getPhoneNumber() != null) {
            sql.VALUES("phone_number", "#{phoneNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getCreditCode() != null) {
            sql.VALUES("credit_code", "#{creditCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getIdcardNumber() != null) {
            sql.VALUES("idcard_number", "#{idcardNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getBank() != null) {
            sql.VALUES("bank", "#{bank,jdbcType=VARCHAR}");
        }
        
        if (record.getBankBranch() != null) {
            sql.VALUES("bank_branch", "#{bankBranch,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountName() != null) {
            sql.VALUES("account_name", "#{accountName,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountNumber() != null) {
            sql.VALUES("account_number", "#{accountNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getIsAuth() != null) {
            sql.VALUES("is_auth", "#{isAuth,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SysDeptExample example) {
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
        sql.SELECT("create_by");
        sql.SELECT("create_date");
        sql.SELECT("update_by");
        sql.SELECT("update_date");
        sql.SELECT("remarks");
        sql.SELECT("registered_capital");
        sql.SELECT("phone_number");
        sql.SELECT("credit_code");
        sql.SELECT("address");
        sql.SELECT("idcard_number");
        sql.SELECT("bank");
        sql.SELECT("bank_branch");
        sql.SELECT("account_name");
        sql.SELECT("account_number");
        sql.SELECT("type");
        sql.SELECT("is_auth");
        sql.FROM("sys_dept");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysDept record = (SysDept) parameter.get("record");
        SysDeptExample example = (SysDeptExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_dept");
        
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
        
        if (record.getRegisteredCapital() != null) {
            sql.SET("registered_capital = #{record.registeredCapital,jdbcType=VARCHAR}");
        }
        
        if (record.getPhoneNumber() != null) {
            sql.SET("phone_number = #{record.phoneNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getCreditCode() != null) {
            sql.SET("credit_code = #{record.creditCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getIdcardNumber() != null) {
            sql.SET("idcard_number = #{record.idcardNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getBank() != null) {
            sql.SET("bank = #{record.bank,jdbcType=VARCHAR}");
        }
        
        if (record.getBankBranch() != null) {
            sql.SET("bank_branch = #{record.bankBranch,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountName() != null) {
            sql.SET("account_name = #{record.accountName,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountNumber() != null) {
            sql.SET("account_number = #{record.accountNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        }
        
        if (record.getIsAuth() != null) {
            sql.SET("is_auth = #{record.isAuth,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_dept");
        
        sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        sql.SET("parent_id = #{record.parentId,jdbcType=VARCHAR}");
        sql.SET("parent_ids = #{record.parentIds,jdbcType=VARCHAR}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("sort = #{record.sort,jdbcType=DECIMAL}");
        sql.SET("create_by = #{record.createBy,jdbcType=VARCHAR}");
        sql.SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        sql.SET("update_by = #{record.updateBy,jdbcType=VARCHAR}");
        sql.SET("update_date = #{record.updateDate,jdbcType=TIMESTAMP}");
        sql.SET("remarks = #{record.remarks,jdbcType=VARCHAR}");
        sql.SET("registered_capital = #{record.registeredCapital,jdbcType=VARCHAR}");
        sql.SET("phone_number = #{record.phoneNumber,jdbcType=VARCHAR}");
        sql.SET("credit_code = #{record.creditCode,jdbcType=VARCHAR}");
        sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("idcard_number = #{record.idcardNumber,jdbcType=VARCHAR}");
        sql.SET("bank = #{record.bank,jdbcType=VARCHAR}");
        sql.SET("bank_branch = #{record.bankBranch,jdbcType=VARCHAR}");
        sql.SET("account_name = #{record.accountName,jdbcType=VARCHAR}");
        sql.SET("account_number = #{record.accountNumber,jdbcType=VARCHAR}");
        sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        sql.SET("is_auth = #{record.isAuth,jdbcType=VARCHAR}");
        
        SysDeptExample example = (SysDeptExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysDept record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_dept");
        
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
        
        if (record.getRegisteredCapital() != null) {
            sql.SET("registered_capital = #{registeredCapital,jdbcType=VARCHAR}");
        }
        
        if (record.getPhoneNumber() != null) {
            sql.SET("phone_number = #{phoneNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getCreditCode() != null) {
            sql.SET("credit_code = #{creditCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getIdcardNumber() != null) {
            sql.SET("idcard_number = #{idcardNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getBank() != null) {
            sql.SET("bank = #{bank,jdbcType=VARCHAR}");
        }
        
        if (record.getBankBranch() != null) {
            sql.SET("bank_branch = #{bankBranch,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountName() != null) {
            sql.SET("account_name = #{accountName,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountNumber() != null) {
            sql.SET("account_number = #{accountNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getIsAuth() != null) {
            sql.SET("is_auth = #{isAuth,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SysDeptExample example, boolean includeExamplePhrase) {
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