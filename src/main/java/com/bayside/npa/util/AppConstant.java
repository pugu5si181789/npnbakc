package com.bayside.npa.util;

/**
 * <p>Title: AppConstant</P>
 * <p>Description:应用层常量类 </p>
 * <p>Copyright: 山东贝赛信息科技有限公司 Copyright (c) 2016</p>
 * @author hadoop
 * @version 1.0
 * @since 2016年9月9日
 */
public class AppConstant {
	/**
	 * 
	 * <p>Title: responseInfo</P>
	 * <p>Description:后台返回前台的信息 </p>
	 * <p>Copyright: 山东贝赛信息科技有限公司 Copyright (c) 2016</p>
	 * @author Administrator
	 * @version 1.0
	 * @since 2016年9月19日
	 */
	public interface responseInfo{
		/**
		 * 保存成功
		 */
		public static final String SAVESUCCESS = "保存成功";
		/**
		 * 保存失败
		 */
		public static final String SAVEERRO = "保存失败";
		/**
		 * 删除成功
		 */
		public static final String DELETESUCCESS = "删除成功";
		/**
		 * 删除失败
		 */
		public static final String DELETEERRO = "删除失败";
		/**
		 * 查询无结果
		 */
		public static final String SELECTEERRO="没有查询到数据";

		
		public static final String UPDATESUCCESS = "修改成功";
		
		public static final String UPDATEEERRO="修改失败";
		
		public static final String INSERTERROR="插入失败";

		/**
		 * id   不能为空
		 */
		public static final String IDNOTNULL = "id不能为空";
		

	}

}
