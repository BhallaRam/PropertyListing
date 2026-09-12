package com.assessment.propertylisting.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.assessment.propertylisting.domain.model.PropertyStatus
import com.assessment.propertylisting.presentation.theme.StatusAvailableBg
import com.assessment.propertylisting.presentation.theme.StatusAvailableText
import com.assessment.propertylisting.presentation.theme.StatusRentedBg
import com.assessment.propertylisting.presentation.theme.StatusRentedText
import com.assessment.propertylisting.presentation.theme.StatusSoldBg
import com.assessment.propertylisting.presentation.theme.StatusSoldText

@Composable
fun StatusBadge(
    status: PropertyStatus,
    modifier: Modifier = Modifier
) {
    val (bgColor, textColor) = when (status) {
        PropertyStatus.AVAILABLE -> StatusAvailableBg to StatusAvailableText
        PropertyStatus.SOLD -> StatusSoldBg to StatusSoldText
        PropertyStatus.RENTED -> StatusRentedBg to StatusRentedText
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(bgColor)
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = status.displayName.uppercase(),
            color = textColor,
            style = MaterialTheme.typography.labelSmall.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                letterSpacing = 0.5.sp
            )
        )
    }
}
