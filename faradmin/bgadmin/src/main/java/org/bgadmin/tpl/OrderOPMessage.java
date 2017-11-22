package org.bgadmin.tpl;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Created by admin on 2017/11/8.
 * 订单消息文本静态常量类
 */
public class OrderOPMessage {

    //-------------------------------订单创建模块消息模版  start-----------------------
    /**订单创建短信模版*/
    public static final String MESSAGE_CREATE_MSG= "";
    /**订单创建消息中心模版*/
    public static final String MESSAGE_CREATE_INFO= "";
    /**订单创建邮件模版*/
    public static final String MESSAGE_CREATE_MAIL= "";
    //-------------------------------订单创建模块消息模版  end-----------------------



    //-------------------------------订单审批模块消息模版  start-----------------------
    /**订单审批通过短信模版*/
    public static final String MESSAGE_APPROVAL_SUCCESS_MSG= "尊敬的顾客${name}您好,您来自${from}尊敬的顾客${name}您好,您来自${from},${dd},${aa}";
    /**订单审批通过消息中心模版*/
    public static final String MESSAGE_APPROVAL_SUCCESS_INFO= "尊敬的顾客{{name}}您好";
    /**订单审批通过邮件模版*/
    public static final String MESSAGE_APPROVAL_SUCCESS_MAIL= "尊敬的顾客{{name}}您好";
    /**订单审批不通过短信模版*/
    public static final String MESSAGE_APPROVAL_FAILED_MSG= "";
    /**订单审批通过消息中心模版*/
    public static final String MESSAGE_APPROVAL_FAILED_INFO= "尊敬的顾客{{name}}您好";
    /**订单审批通过邮件模版*/
    public static final String MESSAGE_APPROVAL_FAILED_MAIL= "尊敬的顾客{{name}}您好";
    //-------------------------------订单审批模块消息模版  end-----------------------



    //------------------------------订单支付模块消息模版   start-------------------------

    //------------------------------订单支付模块消息模版   end----------------------------



    //------------------------------订单发货模块消息模版   start-------------------------

    //------------------------------订单发货模块消息模版   end----------------------------



    //------------------------------订单收货模块消息模版   start-------------------------

    //------------------------------订单收货模块消息模版   end----------------------------



    //------------------------------订单结算模块消息模版   start-------------------------

    //------------------------------订单结算模块消息模版   end----------------------------


    /**
     * 组装消息内容
     * @param map 数据封装载体
     * @param tpl 模版
     * */
    public static String makeMessage(String tpl, Map<String, String> map){
        Configuration cfg = new Configuration();  
        StringTemplateLoader stringLoader = new StringTemplateLoader();  
        String templateContent=tpl;  
        stringLoader.putTemplate("myTemplate",templateContent);
        cfg.setTemplateLoader(stringLoader);  
          
        try {  
            Template template = cfg.getTemplate("myTemplate","utf-8");  
              
            StringWriter writer = new StringWriter();    
            try {  
                template.process(map, writer);  
               return writer.toString();    
            } catch (TemplateException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }    
              
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return null;
    }
    
    public static void main(String[] args) {
    	Map<String,String> m=new HashMap<String,String>();
    	m.put("name", "dad");
    	m.put("from", "台湾");
    	m.put("aa", "dad");
    	//m.put("dd", "台湾");
		System.out.println(OrderOPMessage.makeMessage(OrderOPMessage.MESSAGE_APPROVAL_SUCCESS_MSG, m));
		
    }
}
