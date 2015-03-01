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
			s.push('		<li><a href="#">添加下级分类</a></li>');
			s.push('		<li><a href="#">修改分类</a></li>');
			if(!node.children){
				s.push('	<li class="divider"></li>');
				s.push('	<li><a href="#">删除分类</a></li>');
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
	$('#cate-win').on('click', '.submit', function(){
		$('#cate-form').ajaxSubmit({
			url: ctx + '/category/save',
			success: function(data){
				$('#cate-tree').tree('append', {
					data: data
				});
			}
		});
	});
});