var baseUrl = parent.window.baseUrl || '../';

var queryUrl = baseUrl + "api/strategy/findPage";
var addUrl = baseUrl + "api/strategy/add";
var modUrl = baseUrl + "api/strategy/update";
var delUrl = baseUrl + "api/strategy/delete";
var uploadUrl = baseUrl + "api/file/uploadImg";
var typeUrl = baseUrl + "api/strategytype/findAll";


var ajaxReq = parent.window.ajaxReq || "";

Vue.component('ueditor', {
	  data: function () {
	    return {
	    	editor: null,
	    	focus: false,
	    	id: 'editor_'+new Date().getTime()
	    }
	  },
	  template: '<script :id="id" type="text/plain"></script>',
	  props: {
		  value: {
	        type: String,
	      	default: ''
	      },
	      config: {
	        type: Object
	      }
	    },
	    watch: {
	    	value: function (val, oldVal) {
	    		if(!this.focus){
	    			this.editor.setContent(val);
	    		}
    	    },
	    },
	    mounted() {
	      const _this = this;
	      
	      this.editor = UE.getEditor(this.id, this.config); // 初始化UE
	      this.editor.addListener("ready", function () {
	    	  _this.editor.setContent(_this.value); // 确保UE加载完成后，放入内容。
	      });
	      
	      this.editor.addListener("contentChange", function () {
		        _this.$emit('input', _this.editor.getContent()); // 内容改变后通知父组件。
		   });
	      
	      this.editor.addListener("focus", function () {
		        _this.focus = true; // 当聚焦输入框时，不监控值改变。
		   });

	      this.editor.addListener("blur", function () {
	    	  _this.focus = false; // 当失焦输入框时，监控值改变。
		   });
	    },
	    methods: {
	      getContent() { // 获取内容方法
	        return this.editor.getContent()
	      }
	    },
	    destroyed() {
	      this.editor.destroy();
	    }

	});

var myvue = new Vue({
	    el: '#app',
	    data: function(){
	    	return {
				filters: {
					type: ''
				},
				list: [],
				total: 0,
				page: 1,
				rows: 10,
				listLoading: false,
				sels: [],//列表选中列
				typeOptions:[],
				uploadUrl: uploadUrl,
				isSEO: false, //开启seo配置
				//新增界面数据
				addFormVisible: false,//新增界面是否显示
				addLoading: false, //loading
				//数据
				addForm: {},
				//效验
				addFormRules: {
					type: [
						{  required: true, message: '请选择分类', trigger: 'blur' }
					],
					title: [
						{  required: true, message: '请输入标题', trigger: 'blur' }
					]
				},
				//编辑界面数据
				editFormVisible: false,//编辑界面是否显示
				editLoading: false, //loading
				//数据
				editForm: {},
				//效验
				editFormRules: {
					type: [
						{  required: true, message: '请选择分类', trigger: 'blur' }
					],
					title: [
						{  required: true, message: '请输入标题', trigger: 'blur' }
					]
					
				},
				//查看界面数据
				viewFormVisible: false,//编辑界面是否显示
				//数据
				viewForm: {},
				
				end: ''
			}
		},
		methods: {
			formatDate: function(date){
				return parent.window.formatDate(date, 'yyyy-MM-dd HH:mm:ss');
			},
			typeFormatter: function(row){
				var name = row.type;
				for (var i = 0; i < this.typeOptions.length; i++) {
					var item = this.typeOptions[i];
					if(row.type == item.pid){
						name = item.name;
						break
					}
				}
				return name;
			},
			handleAddUpload: function(res){
				if(res.code > 0){
					this.addForm.illustration = res.data.path;
				}else{
					this.$message({
						message: res.msg,
						type: 'warning'
					});
				}
			},
			handleEditUpload: function(res){
				if(res.code > 0){
					this.editForm.illustration = res.data.path;
				}else{
					this.$message({
						message: res.msg,
						type: 'warning'
					});
				}
			},
			handleTypeOptions: function(cb){
				var self = this;
				var params = {};
				ajaxReq(typeUrl, params, function(res){
					if(res.code > 0){
						self.typeOptions = res.data;
						if(typeof cb == 'function'){
							cb();
						}
					}else{
						self.$message({
							message: res.msg,
							type: 'warning'
						})
					}
				});
			},
			handleSizeChange: function (val) {
				this.rows = val;
				this.getList();
			},
			handleCurrentChange: function (val) {
				this.page = val;
				this.getList();
			},
			//查询
			getList: function () {
				var self = this;
				var params = {
					page: this.page,
					rows: this.rows
				};
				for ( var key in this.filters) {
					if(this.filters[key]){
						params[key] = this.filters[key];
					}
				}
				this.listLoading = true;
				ajaxReq(queryUrl, params, function(res){
					self.listLoading = false;
					if(res.code > 0){
						self.total = res.total;
						self.list = res.data;
						//不够一页，回退一页
						if(self.page != 1 && self.total <= (self.page - 1) * self.rows){
							self.page = self.page - 1;
							self.getList();
						}
					}else{
						self.$message({
							message: res.msg,
							type: 'warning'
						})
					}
				});
			},
			//显示新增界面
			handleAdd: function () {
				this.addFormVisible = true;
				this.addForm = {
						type: 1,
						recommend: 0,
						highlight: 0,
						illustration: '',
						title: '',
						subtitle: '',
						date: '',
						mark: 0,
						site: '',
						content: '',
						status: 0,
						author: '',
						desc: '',
						keywords: '',
						description: ''
				};
			},
			//显示编辑界面
			handleEdit: function (index, row) {
				this.editFormVisible = true;
				this.editForm = Object.assign({}, row);
			},
			//显示查看界面
			handleView: function (index, row) {
				this.viewFormVisible = true;
				this.viewForm = Object.assign({}, row);
			},
			//删除
			handleDel: function (index, row) {
				this.$confirm('确认删除该记录吗？删除后不可恢复。', '提示', {
					type: 'warning'
				}).then(() => {
					var self = this;
					this.listLoading = true;
					ajaxReq(delUrl, {pid: row.pid }, function(res){
						self.listLoading = false;
						if(res.code > 0){
							self.$message({
								message: '删除成功',
								type: 'success'
							});
							self.getList();
						}else{
							self.$message({
								message: res.msg,
								type: 'warning'
							})
						}
					});
					
				}).catch(() => {
				});
			},
			//新增
			addClose: function () {
				this.addFormVisible = false;
				this.addLoading = false;
				this.$refs.addForm.resetFields();
			},
			addSubmit: function () {
				this.$refs.addForm.validate((valid) => {
					if (valid) {
						this.$confirm('确认提交吗？', '提示', {}).then(() => {
							var params = Object.assign({}, this.addForm);
							if(params.mark === 0){
								params.site = '';
							}else{
								params.content = '';
							}
							var self = this;
							this.addLoading = true;
							ajaxReq(addUrl, params, function(res){
								self.addLoading = false;
								if(res.code > 0){
									self.$message({
										message: '新增成功',
										type: 'success'
									});
									self.addFormVisible = false;
									self.getList();
								}else{
									self.$message({
										message: res.msg,
										type: 'warning'
									})
								}
							});
						});
					}
				});
			},
			//编辑
			editClose: function () {
				this.editFormVisible = false;
				this.editLoading = false;
				this.$refs.editForm.resetFields();
			},
			editSubmit: function () {
				this.$refs.editForm.validate((valid) => {
					if (valid) {
						this.$confirm('确认提交吗？', '提示', {}).then(() => {
							var self = this;
							this.editLoading = true;
							var params = Object.assign({}, this.editForm);
							if(params.mark === 0){
								params.site = '';
							}else{
								params.content = '';
							}
							ajaxReq(modUrl, params, function(res){
								self.editLoading = false;
								if(res.code > 0){
									self.$message({
										message: '提交成功',
										type: 'success'
									});
									self.editFormVisible = false;
									self.getList();
								}else{
									self.$message({
										message: res.msg,
										type: 'warning'
									})
								}
							});
							
						});
					}
				});
			},
			selsChange: function (sels) {
				this.sels = sels;
			}
		},
		mounted: function() {
			this.handleTypeOptions(this.getList);
		}
	  });
	


