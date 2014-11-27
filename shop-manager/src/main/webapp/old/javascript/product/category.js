/**
 * 
 */
$(document).ready(function(){
	var categoryTree = $.fn.zTree.init($('#category-tree'), {
		async: {
			enable: true,
			url: ctx + '/category/list',
			autoParam: ['id=parentId']
		},
		callback: {
			onRightClick: function(e, treeId, treeNode){
				if(treeNode && !treeNode.noR){
					categoryTree.selectNode(treeNode);
					$('#category-tree-menu').css({
						left: e.clientX + 'px',
						top: e.clientY + 'px',
						display: 'block'
					});
				}
			}
		}
	}, {
		id: 0,
		name: 'ROOT',
		isParent: true
	});
	
	$('#category-form .submit').click(function(){
		$('#category-form').ajaxSubmit({
			success: function(data){
				var category = categoryTree.getNodeByParam('id', data.id);
				if(category){
					//for edit
					data.isParent = category.isParent;
					$.extend(category, data);
					categoryTree.updateNode(category);
				}
				else {
					//for add
					var parent = categoryTree.getNodeByParam('id', data.parentId);
					if(!parent.isParent){
						parent.isParent = true;
					}
					categoryTree.reAsyncChildNodes(parent, 'refresh');
				}
				$('#category-form')[0].reset();
			}
		});
	});
	
	$('body').append(
		'<ul class="dropdown-menu context-menu" id="category-tree-menu">'+
			'<li><a href="javascript:;" class="edit">编辑</a></li>'+
			'<li><a href="javascript:;" class="add-brother">添加同级分类</a></li>'+
			'<li><a href="javascript:;" class="add-child">添加子分类</a></li>'+
			'<li class="divider"></li>'+
			'<li><a href="javascript:;" class="remove">删除分类</a></li>'+
		'</ul>'
	).bind('mousedown', function(e){
		if(e.target.id == 'category-tree-menu' || $(e.target).closest('#category-tree-menu').length > 0)
			return;
		$('#category-tree-menu').hide();
	});
	
	$('body').on('click', '#category-tree-menu .add-brother', function(){
		var selected = categoryTree.getSelectedNodes();
		if(!selected) return;
		var parent = selected[0].getParentNode();
		$('#parent-category-name').html(parent.name);
		$('#parentId').val(parent.id);
		$('#id').val('');
		$('#category-tree-menu').hide();
	});
	$('body').on('click', '#category-tree-menu .add-child', function(){
		var selected = categoryTree.getSelectedNodes();
		if(!selected) return;
		var parent = selected[0];
		$('#parent-category-name').html(parent.name);
		$('#parentId').val(parent.id);
		$('#id').val('');
		$('#category-tree-menu').hide();
	});
	$('body').on('click', '#category-tree-menu .edit', function(){
		var selected = categoryTree.getSelectedNodes();
		if(!selected) return;
		var category = selected[0];
		$('#parent-category-name').html(category.getParentNode().name);
		$('#category-form input').each(function(){
			if($(this).attr('name') in category){
				$(this).val(category[$(this).attr('name')]);
			}
		});
		$('#category-tree-menu').hide();
	});
	$('body').on('click', '#category-tree-menu .remove', function(){
		
	});
});