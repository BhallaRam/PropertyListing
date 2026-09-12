package com.assessment.propertylisting.data.local.seed

import com.assessment.propertylisting.data.local.entity.PropertyEntity
import com.assessment.propertylisting.domain.model.PropertyStatus
import com.assessment.propertylisting.domain.model.PropertyType

object DatabaseSeeder {

    val INITIAL_PROPERTIES: List<PropertyEntity> = listOf(
        PropertyEntity(
            id = "prop_101",
            propertyName = "Royal Palms Heritage Villa",
            propertyType = PropertyType.VILLA.name,
            location = "Jaipur",
            price = 22500000.0, // 2.25 Cr
            area = 3800,
            configuration = "4 BHK",
            status = PropertyStatus.AVAILABLE.name,
            description = "Luxurious royal villa featuring traditional Rajasthani architecture with modern comforts, private pool, landscaped courtyard, and Italian marble flooring located in the prime Civil Lines area.",
            imageUrl = "https://images.unsplash.com/photo-1613490493576-7fde63acd811?auto=format&fit=crop&w=1000&q=80",
            ownerId = "owner_01",
            ownerName = "Rajesh Sharma"
        ),
        PropertyEntity(
            id = "prop_102",
            propertyName = "Emerald Heights Residency",
            propertyType = PropertyType.APARTMENT.name,
            location = "Jaipur",
            price = 8500000.0, // 85 Lac
            area = 1650,
            configuration = "3 BHK",
            status = PropertyStatus.AVAILABLE.name,
            description = "Contemporary high-rise 3 BHK apartment with panoramic skyline views of Malviya Nagar. Equipped with modular kitchen, clubhouse access, swimming pool, and 24/7 security.",
            imageUrl = "https://images.unsplash.com/photo-1545324418-cc1a3fa10c00?auto=format&fit=crop&w=1000&q=80",
            ownerId = "owner_01",
            ownerName = "Rajesh Sharma"
        ),
        PropertyEntity(
            id = "prop_103",
            propertyName = "The Grand Horizon Suite",
            propertyType = PropertyType.APARTMENT.name,
            location = "Gurgaon",
            price = 19500000.0, // 1.95 Cr
            area = 2400,
            configuration = "3 BHK",
            status = PropertyStatus.AVAILABLE.name,
            description = "Ultra-modern luxury condominium on Golf Course Extension Road. Features smart home automation, wrap-around balconies, private elevator access, and infinity pool.",
            imageUrl = "https://images.unsplash.com/photo-1512917774080-9991f1c4c750?auto=format&fit=crop&w=1000&q=80",
            ownerId = "owner_01",
            ownerName = "Rajesh Sharma"
        ),
        PropertyEntity(
            id = "prop_104",
            propertyName = "Marwar Serene Enclave",
            propertyType = PropertyType.ROW_HOUSE.name,
            location = "Jodhpur",
            price = 9500000.0, // 95 Lac
            area = 2100,
            configuration = "3 BHK",
            status = PropertyStatus.AVAILABLE.name,
            description = "Charming sandstone row house located near Ratanada, featuring authentic jharokhas, private rooftop terrace, dedicated parking, and peaceful residential surroundings.",
            imageUrl = "https://images.unsplash.com/photo-1600585154340-be6161a56a0c?auto=format&fit=crop&w=1000&q=80",
            ownerId = "owner_01",
            ownerName = "Rajesh Sharma"
        ),
        PropertyEntity(
            id = "prop_105",
            propertyName = "Skyline Towers Penthouse",
            propertyType = PropertyType.APARTMENT.name,
            location = "Mumbai",
            price = 45000000.0, // 4.5 Cr
            area = 3100,
            configuration = "4 BHK",
            status = PropertyStatus.AVAILABLE.name,
            description = "Breathtaking sea-facing luxury penthouse in Bandra West with double-height ceilings, private deck, bespoke designer fittings, and 3 reserved car parks.",
            imageUrl = "https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?auto=format&fit=crop&w=1000&q=80",
            ownerId = "owner_01",
            ownerName = "Rajesh Sharma"
        ),
        PropertyEntity(
            id = "prop_106",
            propertyName = "Lutyens Green Estate",
            propertyType = PropertyType.VILLA.name,
            location = "Delhi",
            price = 48000000.0, // 4.8 Cr
            area = 4500,
            configuration = "5 BHK",
            status = PropertyStatus.AVAILABLE.name,
            description = "Exquisite luxury bungalow in South Delhi with sprawling manicured lawns, heated indoor pool, gazebo, staff quarters, and high-level surveillance.",
            imageUrl = "https://images.unsplash.com/photo-1600596542815-ffad4c1539a9?auto=format&fit=crop&w=1000&q=80",
            ownerId = "owner_01",
            ownerName = "Rajesh Sharma"
        ),
        PropertyEntity(
            id = "prop_107",
            propertyName = "CyberTech Smart Living",
            propertyType = PropertyType.APARTMENT.name,
            location = "Bangalore",
            price = 12500000.0, // 1.25 Cr
            area = 1850,
            configuration = "3 BHK",
            status = PropertyStatus.AVAILABLE.name,
            description = "Eco-friendly smart apartment in Whitefield close to premier IT corridors. Equipped with solar backups, rainwater harvesting, EV charging stations, and fitness center.",
            imageUrl = "https://images.unsplash.com/photo-1560448204-e02f11c3d0e2?auto=format&fit=crop&w=1000&q=80",
            ownerId = "owner_01",
            ownerName = "Rajesh Sharma"
        ),
        PropertyEntity(
            id = "prop_108",
            propertyName = "Koregaon Park Manor",
            propertyType = PropertyType.ROW_HOUSE.name,
            location = "Pune",
            price = 16500000.0, // 1.65 Cr
            area = 2600,
            configuration = "4 BHK",
            status = PropertyStatus.AVAILABLE.name,
            description = "Elegant 3-level row house in leafy Koregaon Park with private green backyard, wooden deck, home theater room, and premium clubhouse amenities.",
            imageUrl = "https://images.unsplash.com/photo-1600607687939-ce8a6c25118c?auto=format&fit=crop&w=1000&q=80",
            ownerId = "owner_02",
            ownerName = "Pooja Malhotra"
        ),
        PropertyEntity(
            id = "prop_109",
            propertyName = "Sabarmati Riverfront Residences",
            propertyType = PropertyType.APARTMENT.name,
            location = "Ahmedabad",
            price = 6800000.0, // 68 Lac
            area = 1450,
            configuration = "2 BHK",
            status = PropertyStatus.AVAILABLE.name,
            description = "Scenic riverside apartment with uninterrupted riverfront walkway views, vastu-compliant layout, modular kitchen, and clubhouse.",
            imageUrl = "https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?auto=format&fit=crop&w=1000&q=80",
            ownerId = "owner_02",
            ownerName = "Pooja Malhotra"
        ),
        PropertyEntity(
            id = "prop_110",
            propertyName = "Pink City Urban Nest",
            propertyType = PropertyType.APARTMENT.name,
            location = "Jaipur",
            price = 4500000.0, // 45 Lac
            area = 950,
            configuration = "1 BHK",
            status = PropertyStatus.AVAILABLE.name,
            description = "Chic compact studio-style 1 BHK in Vaishali Nagar, ideal for young professionals or investment. Fully furnished with high-speed fiber internet and power backup.",
            imageUrl = "https://images.unsplash.com/photo-1502005229762-ee152da915d6?auto=format&fit=crop&w=1000&q=80",
            ownerId = "owner_02",
            ownerName = "Pooja Malhotra"
        ),
        PropertyEntity(
            id = "prop_111",
            propertyName = "Golf Links Signature Villa",
            propertyType = PropertyType.VILLA.name,
            location = "Gurgaon",
            price = 37500000.0, // 3.75 Cr
            area = 4200,
            configuration = "4 BHK",
            status = PropertyStatus.RENTED.name,
            description = "Gated golf estate villa with private lawn, private Jacuzzi, servant quarters, and direct views of the 18-hole championship golf course.",
            imageUrl = "https://images.unsplash.com/photo-1580587771525-78b9dba3b914?auto=format&fit=crop&w=1000&q=80",
            ownerId = "owner_02",
            ownerName = "Pooja Malhotra"
        ),
        PropertyEntity(
            id = "prop_112",
            propertyName = "Indiranagar Central Suites",
            propertyType = PropertyType.APARTMENT.name,
            location = "Bangalore",
            price = 14500000.0, // 1.45 Cr
            area = 1750,
            configuration = "2 BHK",
            status = PropertyStatus.AVAILABLE.name,
            description = "Boutique residential apartment nestled in the heart of Indiranagar. Walking distance to elite dining, metro station, and commercial hubs.",
            imageUrl = "https://images.unsplash.com/photo-1493809842364-78817add7ffb?auto=format&fit=crop&w=1000&q=80",
            ownerId = "owner_02",
            ownerName = "Pooja Malhotra"
        ),
        PropertyEntity(
            id = "prop_113",
            propertyName = "Blue Lagoon Lakefront Villa",
            propertyType = PropertyType.VILLA.name,
            location = "Pune",
            price = 28500000.0, // 2.85 Cr
            area = 3600,
            configuration = "4 BHK",
            status = PropertyStatus.AVAILABLE.name,
            description = "Waterfront designer villa in Baner overlooking serene waters. Offers infinity plunge pool, open barbecue deck, landscaped garden, and multi-car parking.",
            imageUrl = "https://images.unsplash.com/photo-1512915922686-57c11dde9b6b?auto=format&fit=crop&w=1000&q=80",
            ownerId = "owner_01",
            ownerName = "Rajesh Sharma"
        ),
        PropertyEntity(
            id = "prop_114",
            propertyName = "Connaught Prime Residency",
            propertyType = PropertyType.APARTMENT.name,
            location = "Delhi",
            price = 26000000.0, // 2.6 Cr
            area = 2200,
            configuration = "3 BHK",
            status = PropertyStatus.SOLD.name,
            description = "Heritage inspired luxury apartment in Central Delhi featuring high ornate ceilings, central climate control, and concierge services.",
            imageUrl = "https://images.unsplash.com/photo-1567496898669-ee935f5f647a?auto=format&fit=crop&w=1000&q=80",
            ownerId = "owner_01",
            ownerName = "Rajesh Sharma"
        )
    )
}
