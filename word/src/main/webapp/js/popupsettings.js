 $( document ).ready(function() {

$.getJSON("../auth/log.do", function(result) {
      if (result.status == "success"){
         var member = result.member;
         $("#setemail").val(member.email);
         $("#setnick").val(member.nick);
         $("#nickBefore").val(member.nick);
      } else if (result.status == "failure"){
         
      }
   });
   
   
   
$(function(){
   $('#setnick').keyup(function() {
   
   var member={"nick":""};

    $.ajax({
        type: 'POST',
        url: "../ajax/member/detailByNick.do",
        data:  {
            nick : $("#setnick").val()
         },
        success: function(result) {
           if (result.nick != null) {
               member.nick = result.nick;
           }
         },
        dataType: "json",
        async:false
      });

    if(member.nick != "") {   
          $("#nickCheck").val("1");
         $('font[name=ncheck]').html("중복된 닉네임 입니다.");
         $('font[name=ncheck]').css("color","red");
   } else if (member.nick == "") {
         $("#nickCheck").val("0");
         $('font[name=ncheck]').html("사용 가능한 닉네임 입니다.");
         $('font[name=ncheck]').css("color","blue");
   }
   });
});  

var regexPassword =  /^(?=.*[a-zA-Z])(?=.*[0-9]).{6,16}$/;

   $("#change").click(function(event) {
      
       var checkValue = $("#nickCheck").val();
       var nickBefore = $("#nickBefore").val();

       
       if((checkValue != "") && (nickBefore != "")){
          
          if((checkValue == "1") && (nickBefore != $("#setnick").val())){
        	  $.dialog({

                  // 'alert', 'confirm', 'info' or 'tips'
                  type : 'alert',     
                  titleText : '닉네임이 중복되었습니다.',
                  showTitle : true,
                  contentHtml : '',
                  dialogClass : '',
                  autoClose : 0,
                  overlayClose : false,
                  drag : false,

                  buttonText : {
                      ok : 'OK',
                      cancel : 'Cancel',
                      delete : 'Delete'
                  },
                  buttonClass : {
                      ok : '',
                      cancel : '',
                      delete : ''
                  },

                  infoText : '',      // working in info type
                  infoIcon : '',      // working in info type

                  onClickOk : function(){},
                  onClickCancel : function(){},
                  onClickClose : function(){},

                  onBeforeShow : function(){},
                  onShow : function(){},
                  onBeforeClosed : function(){},
                  onClosed : function(){}
                  
                });
            document.mysetting.setnick.focus();
         }else if((checkValue == "0") && (nickBefore != $("#setnick").val())){
            
            $.ajax({
                 type: 'POST',
                 url: "../ajax/member/nickupdate.do",
                 data:  {
                     nick : $("#setnick").val(),
                     email : $("#setemail").val()
                  },
                 success: function(result) {
                     if (result.status == "success") {
                        $("#setnick").val(result.nick);
                        $("#nickCheck").val("");
                        $("#nickBefore").val("result.nick");
                        //member.nick = result.nick;
                        if(!($("#setpassword").val() != "" && $("#setpassword_confirm").val() != "" && $("#localpassword").val() != "")){
                        	  $.dialog({

                                  // 'alert', 'confirm', 'info' or 'tips'
                                  type : 'alert',     
                                  titleText : '설정을 변경하였습니다.',
                                  showTitle : true,
                                  contentHtml : '',
                                  dialogClass : '',
                                  autoClose : 0,
                                  overlayClose : false,
                                  drag : false,

                                  buttonText : {
                                      ok : 'OK',
                                      cancel : 'Cancel',
                                      delete : 'Delete'
                                  },
                                  buttonClass : {
                                      ok : '',
                                      cancel : '',
                                      delete : ''
                                  },

                                  infoText : '',      // working in info type
                                  infoIcon : '',      // working in info type

                                  onClickOk : function(){},
                                  onClickCancel : function(){},
                                  onClickClose : function(){},

                                  onBeforeShow : function(){},
                                  onShow : function(){},
                                  onBeforeClosed : function(){},
                                  onClosed : function(){}
                                  
                                });
                        }
                     }else if(result.status == "failure"){
                    	  $.dialog({

                              // 'alert', 'confirm', 'info' or 'tips'
                              type : 'alert',     
                              titleText : '설정이 변경되지 않았습니다.',
                              showTitle : true,
                              contentHtml : '',
                              dialogClass : '',
                              autoClose : 0,
                              overlayClose : false,
                              drag : false,

                              buttonText : {
                                  ok : 'OK',
                                  cancel : 'Cancel',
                                  delete : 'Delete'
                              },
                              buttonClass : {
                                  ok : '',
                                  cancel : '',
                                  delete : ''
                              },

                              infoText : '',      // working in info type
                              infoIcon : '',      // working in info type

                              onClickOk : function(){},
                              onClickCancel : function(){},
                              onClickClose : function(){},

                              onBeforeShow : function(){},
                              onShow : function(){},
                              onBeforeClosed : function(){},
                              onClosed : function(){}
                              
                            });
                        $("#setnick").val(result.nick);
                     }
                     
                  if(result.nick != "") {   
                        $('font[name=ncheck]').html("");
                  } else if (result.nick == "") {
                        $('font[name=ncheck]').html("");
                  }
                  
                  },
                 dataType: "json",
                 async:false
               });
         } 
       }   
       
       if($("#setpassword").val() != "" && $("#setpassword_confirm").val() != "" && $("#localpassword").val() != ""){
         
         if($("#setpassword").val() != $("#setpassword_confirm").val()) {
               $("#localpassword").val("");
               $("#setpassword").val("");
               $("#setpassword_confirm").val("");
               $.dialog({

                   // 'alert', 'confirm', 'info' or 'tips'
                   type : 'alert',     
                   titleText : '비밀번호가 일치하지 않습니다. 다시 입력해주세요.',
                   showTitle : true,
                   contentHtml : '',
                   dialogClass : '',
                   autoClose : 0,
                   overlayClose : false,
                   drag : false,

                   buttonText : {
                       ok : 'OK',
                       cancel : 'Cancel',
                       delete : 'Delete'
                   },
                   buttonClass : {
                       ok : '',
                       cancel : '',
                       delete : ''
                   },

                   infoText : '',      // working in info type
                   infoIcon : '',      // working in info type

                   onClickOk : function(){},
                   onClickCancel : function(){},
                   onClickClose : function(){},

                   onBeforeShow : function(){},
                   onShow : function(){},
                   onBeforeClosed : function(){},
                   onClosed : function(){}
                   
                 });
            document.mysetting.setpassword_confirm.focus();
         }else if(!$('#setpassword').val().match(regexPassword)) {
        	  $.dialog({

                  // 'alert', 'confirm', 'info' or 'tips'
                  type : 'alert',     
                  titleText : '비밀번호 형식에 맞지 않습니다.',
                  showTitle : true,
                  contentHtml : '',
                  dialogClass : '',
                  autoClose : 0,
                  overlayClose : false,
                  drag : false,

                  buttonText : {
                      ok : 'OK',
                      cancel : 'Cancel',
                      delete : 'Delete'
                  },
                  buttonClass : {
                      ok : '',
                      cancel : '',
                      delete : ''
                  },

                  infoText : '',      // working in info type
                  infoIcon : '',      // working in info type

                  onClickOk : function(){},
                  onClickCancel : function(){},
                  onClickClose : function(){},

                  onBeforeShow : function(){},
                  onShow : function(){},
                  onBeforeClosed : function(){},
                  onClosed : function(){}
                  
                });
            document.mysetting.setpassword.focus();
         }else{
             $.ajax({
                 type: 'POST',
                 url: "../ajax/member/pwdupdate.do",
                 data:  {
                     email : $("#setemail").val(),
                     localpassword : $("#localpassword").val(),
                     newPass  : $("#setpassword").val()
                  },
                 success: function(result) {
                     if (result.status == "success") {
                        $("#localpassword").val("");
                        $("#setpassword").val("");
                        $("#setpassword_confirm").val("");
                        $.dialog({

                            // 'alert', 'confirm', 'info' or 'tips'
                            type : 'alert',     
                            titleText : '설정을 변경했습니다.',
                            showTitle : true,
                            contentHtml : '',
                            dialogClass : '',
                            autoClose : 0,
                            overlayClose : false,
                            drag : false,

                            buttonText : {
                                ok : 'OK',
                                cancel : 'Cancel',
                                delete : 'Delete'
                            },
                            buttonClass : {
                                ok : '',
                                cancel : '',
                                delete : ''
                            },

                            infoText : '',      // working in info type
                            infoIcon : '',      // working in info type

                            onClickOk : function(){},
                            onClickCancel : function(){},
                            onClickClose : function(){},

                            onBeforeShow : function(){},
                            onShow : function(){},
                            onBeforeClosed : function(){},
                            onClosed : function(){}
                            
                          }); 
                     }else if(result.status == "failure"){
                        $("#localpassword").val("");
                        $("#setpassword").val("");
                        $("#setpassword_confirm").val("");
                        $.dialog({

                            // 'alert', 'confirm', 'info' or 'tips'
                            type : 'alert',     
                            titleText : '비밀번호가 일치하지 않습니다.',
                            showTitle : true,
                            contentHtml : '',
                            dialogClass : '',
                            autoClose : 0,
                            overlayClose : false,
                            drag : false,

                            buttonText : {
                                ok : 'OK',
                                cancel : 'Cancel',
                                delete : 'Delete'
                            },
                            buttonClass : {
                                ok : '',
                                cancel : '',
                                delete : ''
                            },

                            infoText : '',      // working in info type
                            infoIcon : '',      // working in info type

                            onClickOk : function(){},
                            onClickCancel : function(){},
                            onClickClose : function(){},

                            onBeforeShow : function(){},
                            onShow : function(){},
                            onBeforeClosed : function(){},
                            onClosed : function(){}
                            
                          }); 
                        document.mysetting.setpassword_confirm.focus();
                     }
                     
                  if(result.password != "") {   
                        $('font[name=pcheck]').html("");
                  } else if (result.newPass == "") {
                        $('font[name=pcheck]').html("");
                  }
                    
                  },
                 dataType: "json",
                 async:false
               });

            }
         
      }

       var fd = new FormData($("#settingForm")[0]);
     $.ajax({
            url:"../ajax/member/photupdate.do",
            type:"POST",
            data: fd,
            async:true,
            cache:false,
            contentType:false,
            processData:false,
         success: function(result) {
               if (result.status == "success") {
                  window.location.reload(); 
               } else if (result.status == "failure") {
            	   $.dialog({

                       // 'alert', 'confirm', 'info' or 'tips'
                       type : 'alert',     
                       titleText : '설정 변경에 실패하였습니다.',
                       showTitle : true,
                       contentHtml : '',
                       dialogClass : '',
                       autoClose : 0,
                       overlayClose : false,
                       drag : false,

                       buttonText : {
                           ok : 'OK',
                           cancel : 'Cancel',
                           delete : 'Delete'
                       },
                       buttonClass : {
                           ok : '',
                           cancel : '',
                           delete : ''
                       },

                       infoText : '',      // working in info type
                       infoIcon : '',      // working in info type

                       onClickOk : function(){},
                       onClickCancel : function(){},
                       onClickClose : function(){},

                       onBeforeShow : function(){},
                       onShow : function(){},
                       onBeforeClosed : function(){},
                       onClosed : function(){}
                       
                     });
                  window.location.reload();
               } else if (result.status == "noChange") {
                 window.location.reload();
               }
         }
       });
   });
   
   $("#deletebtn").click(function(event) {
      
       $.ajax({
           type: 'POST',
           url: "../ajax/member/delete.do",
           data:  {
              password : $("#deletepassword").val(),
              email : $("#setemail").val()
            },
           success: function(result) {
               if (result.status == "success") {
            	   $.dialog({

                       // 'alert', 'confirm', 'info' or 'tips'
                       type : 'alert',     
                       titleText : '회원탈퇴 완료되었습니다.',
                       showTitle : true,
                       contentHtml : '',
                       dialogClass : '',
                       autoClose : 0,
                       overlayClose : false,
                       drag : false,

                       buttonText : {
                           ok : 'OK',
                           cancel : 'Cancel',
                           delete : 'Delete'
                       },
                       buttonClass : {
                           ok : '',
                           cancel : '',
                           delete : ''
                       },

                       infoText : '',      // working in info type
                       infoIcon : '',      // working in info type

                       onClickOk : function(){},
                       onClickCancel : function(){},
                       onClickClose : function(){},

                       onBeforeShow : function(){},
                       onShow : function(){},
                       onBeforeClosed : function(){},
                       onClosed : function(){}
                       
                     }); 
                  location.href = "../auth/logout.do";
               }else if(result.status == "failure"){
            	   $.dialog({

                       // 'alert', 'confirm', 'info' or 'tips'
                       type : 'alert',     
                       titleText : '비밀번호가 일치하지 않습니다.',
                       showTitle : true,
                       contentHtml : '',
                       dialogClass : '',
                       autoClose : 0,
                       overlayClose : false,
                       drag : false,

                       buttonText : {
                           ok : 'OK',
                           cancel : 'Cancel',
                           delete : 'Delete'
                       },
                       buttonClass : {
                           ok : '',
                           cancel : '',
                           delete : ''
                       },

                       infoText : '',      // working in info type
                       infoIcon : '',      // working in info type

                       onClickOk : function(){},
                       onClickCancel : function(){},
                       onClickClose : function(){},

                       onBeforeShow : function(){},
                       onShow : function(){},
                       onBeforeClosed : function(){},
                       onClosed : function(){}
                       
                     });
                  $("#deletepassword").val("");
                  document.deletecheck.deletepassword.focus();
               }
            },
              
           dataType: "json",
           async:false
         });
       
   });

   var regexEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
   var regexPassword =  /^(?=.*[a-zA-Z])(?=.*[0-9]).{6,16}$/;
      

   $(function(){
	     $('#setpassword').keyup(function(){
	      $('font[name=prcheck]').text('');
	          if(!$('#setpassword').val().match(regexPassword)) {
	          $('font[name=prcheck]').html("비밀번호는 숫자와 영문자 조합으로 6~16자리를 사용해 주세요");
	          $('font[name=prcheck]').css("color","red");
	          } else {
	          $('font[name=prcheck]').text('');
	          }
	     });
	  });
   
   

   $('#setpassword_confirm').keyup(function(){
       if($('#setpassword').val()!=$('#setpassword_confirm').val()){
       $('font[name=pcheck]').text('');
        $('font[name=pcheck]').html("암호가 일치하지 않습니다.");
        $('font[name=pcheck]').css("color","red");
        return;
       }else {
        $('font[name=pcheck]').html("암호가 일치합니다.");
        $('font[name=pcheck]').css("color","blue");
       }
      });

   $(function() {
	    $(document).on('change','#inputfiles', function(){
	        readURL(this);
	    });
	});
   

	function readURL(input) {
	    if (input.files && input.files[0]) {
	    var reader = new FileReader();

	    reader.onload = function (e) {
	            $('#imgPreview').attr('src', e.target.result);
	        }

	      reader.readAsDataURL(input.files[0]);
	    }
	}
	
 }); 	
	
