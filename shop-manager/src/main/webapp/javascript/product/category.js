/**
 * 
 */
$(document).ready(function(){
	$.fn.zTree.init($('#category-tree'), {
		async: {
			enable: true,
			url: ctx + '/category/list',
			autoParam: ['id', 'categoryName']
		}
	});
	
	$('#category-form .submit').click(function(){
		$('#category-form').ajaxSubmit({
			success: function(data){
				
			}
		});
	});
});