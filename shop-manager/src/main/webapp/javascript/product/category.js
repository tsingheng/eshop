/**
 * 
 */
$(document).ready(function(){
	$.fn.zTree.init($('#treeDemo'), {
		async: {
			enable: true,
			url: ctx + '/category/list',
			autoParam: ['id', 'name=categoryName']
		}
	});
	
	$('#category-form .submit').click(function(){
		$('#category-form').ajaxSubmit({
			success: function(data){
				
			}
		});
	});
});