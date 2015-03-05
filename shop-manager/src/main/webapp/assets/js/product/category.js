$(document).ready(function(){
	$('#category-tree').tree({
		animate: true,
		url: ctx + '/category/cate-tree',
		formatter: function(node){
			var s = [];
			s.push(node.text + '<span>');
			s.push('<div class="btn-group">');
			s.push('	<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">');
			s.push('		操作 <span class="caret"></span>');
			s.push('	</button>');
			s.push('	<ul class="dropdown-menu" role="menu">');
			s.push('		<li><a href="javascript:;" class="add-brother-cate">添加同级分类</a></li>');
			s.push('		<li><a href="javascript:;" class="add-child-cate">添加下级分类</a></li>');
			s.push('		<li><a href="javascript:;" class="edit-cate">修改分类</a></li>');
			if(!(node.children && node.children.length)){
				s.push('	<li class="divider"></li>');
				s.push('	<li><a href="javascript:;" class="remove-cate">删除分类</a></li>');
			}
			s.push('	</ul>');
			s.push('</div>');
			s.push('<span>');
			return s.join('');
		},
		onContextMenu: function(e, node){
			$(this).tree('select', node.target);
		}
	});
	$('#category-tree').on('click', '.btn-group', function(){
		$(this).hasClass('open') ? $(this).removeClass('open') : $(this).addClass('open');
	});
	$('#category-tree').on('mouseleave', '.tree-node-hover', function(){
		var btnGroup = $(this).find('.btn-group');
		if(btnGroup.hasClass('open')){
			btnGroup.removeClass('open');
		}
	});
	$('#category-tree').on('click', '.add-brother-cate', function(){
		$('#cate-win').window('open');
		var selectedCate = $('#category-tree').tree('getSelected');
		var parentId = 0;
		if(selectedCate){
			parentId = selectedCate.parentId;
		}
		$('#cate-win').window('refresh', ctx + '/category/form?parentId=' + parentId);
	});
	$('#category-tree').on('click', '.add-child-cate', function(){
		$('#cate-win').window('open');
		var selectedCate = $('#category-tree').tree('getSelected');
		var parentId = 0;
		if(selectedCate){
			parentId = selectedCate.id;
		}
		$('#cate-win').window('refresh', ctx + '/category/form?parentId=' + parentId);
	});
	$('#category-tree').on('click', '.edit-cate', function(){
		var selectedCate = $('#category-tree').tree('getSelected');
		if(selectedCate){
			$('#cate-win').window('open');
			$('#cate-win').window('refresh', ctx + '/category/form?id=' + selectedCate.id);
		}
	});
	$('#category-tree').on('click', '.remove-cate', function(){
		var selectedCate = $('#category-tree').tree('getSelected');
		if(selectedCate){
			var confirm = false;
			$.messager.confirm('系统消息', '确定要删除分类[' + selectedCate.text + ']?', function(result){
				confirm = result;
			});
			if(!confirm){
				return;
			}
			$.ajax({
				url: ctx + '/category/remove',
				data: {
					id: selectedCate.id
				},
				type: 'post',
				success: function(data){
					cateTree().tree('remove', selectedCate.target);
				}
			});
		}
	});
	$('#cate-win').on('click', '.submit', function(){
		$('#cate-form').ajaxSubmit({
			url: ctx + '/category/save',
			success: function(data){
				var node = $('#category-tree').tree('find', data.data.id);
				if(node){
					$('#category-tree').tree('update', $.extend(data.data, {
						target: node.target
					}));
				}else{
					var parent = cateTree().tree('find', data.data.parentId);
					$('#category-tree').tree('append', {
						parent: parent ? parent.target : null,
						data: data.data
					});
				}
				$('#cate-win').window('close');
			}
		});
	});
	
	function cateTree(){
		return $('#category-tree');
	}
});