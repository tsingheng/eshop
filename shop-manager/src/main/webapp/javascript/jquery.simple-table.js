/**
 * 
 */
(function($){
	function init(jq){
		
	};
	/**
	 * 请求数据
	 */
	function request(jq, param){
		var opts = $(jq).data('table');
		if(param){
			opts.queryParams = param;
		}
		if(!opts.url){
			return;
		}
		$(jq).table('loading');
		setTimeout(function(){
			doRequest();
		}, 0);
		function doRequest(){
			$.ajax({
				url: opts.url,
				data: opts.queryParams,
				dataType: 'json',
				success: function(data){
					renderTable(jq, data);
					setTimeout(function(){
						$(jq).table('loaded');
					});
				}
			});
		};
	};
	/**
	 * 渲染表格数据
	 */
	function renderTable(jq, data){
		var rows;
		if(data instanceof Array){
			rows = data;
		}
		else if(data.items){
			rows = data.items;
		}
		if(!rows){
			return;
		}
		var opts = $(jq).data('table');
		if(!opts.columns){
			return;
		}
		var html = [];
		for(var i = 0; i < rows.length; i++){
			html.push('<tr>');
			var row = rows[i];
			for(var j = 0; j < opts.columns.length; j++){
				html.push('<td>');
				if(opts.columns.dataIndex){
					html.push(row[opts.columns.dataIndex]);
				}
				html.push('</td>');
			}
			html.push('</tr>');
		}
		$(jq).children('tbody').html(html);
	};
	function renderPager(jq, data){
		var pager = $('#' + $(jq).attr('id') + '-pager');
		pager.find('.page-info').html('共' + data.totalCount + '条数据,当前显示' + data.start + '-' + (data.start+data.limit) + '条');
		
	};
	$.fn.table = function(option, param){
		if(typeof option == 'string'){
			return $.fn.table.methods[option](this, param);
		}
		return this.each(function(){
			var state = $(this).data('table');
			if(!state){
				var opts = $.fn.table.parseOptions(this);
				var columns = [];
				$(this).find('colgroup').children().each(function(){
					columns.push({
						dataIndex: $(this).attr('data-index')
					});
				});
				$.extend(opts, {
					columns: columns
				});
				$(this).data('table', {
					options: opts
				});
			}
			
			init(this);
			request(this, param);
		});
	};
	$.fn.table.methods = {
		load: function(jq, param){
			return jq.each(function(){
				request(this, param);
			});
		},
		loading: function(jq){
			return jq.each(function(){
				var panel = $('#' + $(this).attr('id') + '-wrapper');
				$('<div class="loading-mask"></div>').appendTo(panel);
				$('<div class="loading-mask-msg"></div>').appendTo(panel);
			});
		},
		loaded: function(jq){
			return jq.each(function(){
				var panel = $('#' + $(this).attr('id') + '-wrapper');
				panel.children('div.loading-mask').remove();
				panel.children('div.loading-mask-msg').remove();
			});
		}
	};
	$.fn.table.parseOptions = function(jq){
		var t = $(jq);
		var clonum = [];
		return $.extend($.fn.table.defaults, {
			url: t.attr('url')
		});
	};
	$.fn.table.defaults = {
		page: 1,
		limit: 20,
		queryParams: {}
	};
})(jQuery);